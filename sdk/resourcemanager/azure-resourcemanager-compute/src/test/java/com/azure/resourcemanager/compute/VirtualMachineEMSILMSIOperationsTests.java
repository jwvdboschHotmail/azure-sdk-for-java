// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.compute;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.Region;
import com.azure.core.test.annotation.DoNotRecord;
import com.azure.resourcemanager.authorization.models.BuiltInRole;
import com.azure.resourcemanager.authorization.models.RoleAssignment;
import com.azure.resourcemanager.compute.models.KnownLinuxVirtualMachineImage;
import com.azure.resourcemanager.compute.models.ResourceIdentityType;
import com.azure.resourcemanager.compute.models.VirtualMachine;
import com.azure.resourcemanager.compute.models.VirtualMachineSizeTypes;
import com.azure.resourcemanager.msi.models.Identity;
import com.azure.resourcemanager.network.models.Network;
import com.azure.resourcemanager.resources.fluentcore.model.Creatable;
import com.azure.resourcemanager.resources.models.ResourceGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class VirtualMachineEMSILMSIOperationsTests extends ComputeManagementTest {
    // LiveOnly because test needs to be refactored for storing/evaluating PrincipalId
    private String rgName = "";
    private Region region = Region.US_WEST2;
    private final String vmName = "javavm";

    @Override
    protected void cleanUpResources() {
        this.resourceManager.resourceGroups().beginDeleteByName(rgName);
    }

    @Test
    @DoNotRecord(skipInPlayback = true)
    public void canCreateUpdateVirtualMachineWithEMSI() {
        // LiveOnly because "test timing out after latest test proxy update"
        // this.resourceManager.resourceGroups().beginDeleteByName("41522c6e938c4f6");
        rgName = generateRandomResourceName("java-emsi-c-rg", 15);
        String identityName1 = generateRandomResourceName("msi-id", 15);
        String identityName2 = generateRandomResourceName("msi-id", 15);
        String networkName = generateRandomResourceName("nw", 10);

        // Prepare a definition for yet-to-be-created resource group
        //
        Creatable<ResourceGroup> creatableRG = resourceManager.resourceGroups().define(rgName).withRegion(region);

        // Create a virtual network residing in the above RG
        //
        final Network network = networkManager.networks()
            .define(networkName)
            .withRegion(region)
            .withNewResourceGroup(creatableRG)
            .create();

        // Create an "User Assigned (External) MSI" residing in the above RG and assign reader access to the virtual
        // network
        //
        final Identity createdIdentity = msiManager.identities()
            .define(identityName1)
            .withRegion(region)
            .withNewResourceGroup(creatableRG)
            .withAccessTo(network, BuiltInRole.READER)
            .create();

        // Prepare a definition for yet-to-be-created "User Assigned (External) MSI" with contributor access to the
        // resource group
        // it resides
        //
        Creatable<Identity> creatableIdentity = msiManager.identities()
            .define(identityName2)
            .withRegion(region)
            .withNewResourceGroup(creatableRG)
            .withAccessToCurrentResourceGroup(BuiltInRole.CONTRIBUTOR);

        // Create a virtual machine and associate it with existing and yet-t-be-created identities
        //
        VirtualMachine virtualMachine = computeManager.virtualMachines()
            .define(vmName)
            .withRegion(region)
            .withNewResourceGroup(rgName)
            .withNewPrimaryNetwork("10.0.0.0/28")
            .withPrimaryPrivateIPAddressDynamic()
            .withoutPrimaryPublicIPAddress()
            .withPopularLinuxImage(KnownLinuxVirtualMachineImage.UBUNTU_SERVER_16_04_LTS)
            .withRootUsername("Foo12")
            .withSsh(sshPublicKey())
            .withExistingUserAssignedManagedServiceIdentity(createdIdentity)
            .withNewUserAssignedManagedServiceIdentity(creatableIdentity)
            .withSize(VirtualMachineSizeTypes.STANDARD_A0)
            .create();

        Assertions.assertNotNull(virtualMachine);
        Assertions.assertNotNull(virtualMachine.innerModel());
        Assertions.assertTrue(virtualMachine.isManagedServiceIdentityEnabled());
        Assertions.assertNull(virtualMachine.systemAssignedManagedServiceIdentityPrincipalId()); // No Local MSI enabled
        Assertions.assertNull(virtualMachine.systemAssignedManagedServiceIdentityTenantId()); // No Local MSI enabled

        // Ensure the "User Assigned (External) MSI" id can be retrieved from the virtual machine
        //
        Set<String> emsiIds = virtualMachine.userAssignedManagedServiceIdentityIds();
        Assertions.assertNotNull(emsiIds);
        Assertions.assertEquals(2, emsiIds.size());

        // Ensure the "User Assigned (External) MSI"s matches with the those provided as part of VM create
        //
        Identity implicitlyCreatedIdentity = null;
        for (String emsiId : emsiIds) {
            Identity identity = msiManager.identities().getById(emsiId);
            Assertions.assertNotNull(identity);
            Assertions.assertTrue(
                identity.name().equalsIgnoreCase(identityName1) || identity.name().equalsIgnoreCase(identityName2));
            Assertions.assertNotNull(identity.principalId());

            if (identity.name().equalsIgnoreCase(identityName2)) {
                implicitlyCreatedIdentity = identity;
            }
        }
        Assertions.assertNotNull(implicitlyCreatedIdentity);

        // Ensure expected role assignment exists for explicitly created EMSI
        //
        PagedIterable<RoleAssignment> roleAssignmentsForNetwork
            = this.msiManager.authorizationManager().roleAssignments().listByScope(network.id());
        boolean found = false;
        for (RoleAssignment roleAssignment : roleAssignmentsForNetwork) {
            if (roleAssignment.principalId() != null
                && roleAssignment.principalId().equalsIgnoreCase(createdIdentity.principalId())) {
                found = true;
                break;
            }
        }
        Assertions.assertTrue(found,
            "Expected role assignment not found for the virtual network for identity" + createdIdentity.name());

        RoleAssignment assignment = lookupRoleAssignmentUsingScopeAndRoleAsync(network.id(), BuiltInRole.READER,
            createdIdentity.principalId()).block();

        Assertions.assertNotNull(assignment,
            "Expected role assignment with ROLE not found for the virtual network for identity");

        // Ensure expected role assignment exists for explicitly created EMSI
        //
        ResourceGroup resourceGroup = resourceManager.resourceGroups().getByName(virtualMachine.resourceGroupName());
        Assertions.assertNotNull(resourceGroup);

        PagedIterable<RoleAssignment> roleAssignmentsForResourceGroup
            = this.msiManager.authorizationManager().roleAssignments().listByScope(resourceGroup.id());
        found = false;
        for (RoleAssignment roleAssignment : roleAssignmentsForResourceGroup) {
            if (roleAssignment.principalId() != null
                && roleAssignment.principalId().equalsIgnoreCase(implicitlyCreatedIdentity.principalId())) {
                found = true;
                break;
            }
        }
        Assertions.assertTrue(found, "Expected role assignment not found for the resource group for identity"
            + implicitlyCreatedIdentity.name());

        assignment = lookupRoleAssignmentUsingScopeAndRoleAsync(resourceGroup.id(), BuiltInRole.CONTRIBUTOR,
            implicitlyCreatedIdentity.principalId()).block();

        Assertions.assertNotNull(assignment,
            "Expected role assignment with ROLE not found for the resource group for identity");

        emsiIds = virtualMachine.userAssignedManagedServiceIdentityIds();
        Iterator<String> itr = emsiIds.iterator();
        // Remove both (all) identities
        virtualMachine.update()
            .withoutUserAssignedManagedServiceIdentity(itr.next())
            .withoutUserAssignedManagedServiceIdentity(itr.next())
            .apply();
        //
        Assertions.assertEquals(0, virtualMachine.userAssignedManagedServiceIdentityIds().size());
        if (virtualMachine.managedServiceIdentityType() != null) {
            Assertions.assertTrue(virtualMachine.managedServiceIdentityType().equals(ResourceIdentityType.NONE));
        }
        // fetch vm again and validate
        virtualMachine.refresh();
        //
        Assertions.assertEquals(0, virtualMachine.userAssignedManagedServiceIdentityIds().size());
        if (virtualMachine.managedServiceIdentityType() != null) {
            Assertions.assertTrue(virtualMachine.managedServiceIdentityType().equals(ResourceIdentityType.NONE));
        }
        //
        itr = emsiIds.iterator();
        Identity identity1 = msiManager.identities().getById(itr.next());
        Identity identity2 = msiManager.identities().getById(itr.next());
        //
        // Update VM by enabling System-MSI and add two identities
        virtualMachine.update()
            .withSystemAssignedManagedServiceIdentity()
            .withExistingUserAssignedManagedServiceIdentity(identity1)
            .withExistingUserAssignedManagedServiceIdentity(identity2)
            .apply();

        Assertions.assertNotNull(virtualMachine.userAssignedManagedServiceIdentityIds());
        Assertions.assertEquals(2, virtualMachine.userAssignedManagedServiceIdentityIds().size());
        Assertions.assertNotNull(virtualMachine.managedServiceIdentityType());
        Assertions.assertTrue(
            virtualMachine.managedServiceIdentityType().equals(ResourceIdentityType.SYSTEM_ASSIGNED_USER_ASSIGNED));
        //
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityPrincipalId());
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityTenantId());
        //
        virtualMachine.refresh();
        Assertions.assertNotNull(virtualMachine.userAssignedManagedServiceIdentityIds());
        Assertions.assertEquals(2, virtualMachine.userAssignedManagedServiceIdentityIds().size());
        Assertions.assertNotNull(virtualMachine.managedServiceIdentityType());
        Assertions.assertTrue(
            virtualMachine.managedServiceIdentityType().equals(ResourceIdentityType.SYSTEM_ASSIGNED_USER_ASSIGNED));
        //
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityPrincipalId());
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityTenantId());
        //
        itr = emsiIds.iterator();
        // Remove identities one by one (first one)
        virtualMachine.update().withoutUserAssignedManagedServiceIdentity(itr.next()).apply();
        //
        Assertions.assertNotNull(virtualMachine.userAssignedManagedServiceIdentityIds());
        Assertions.assertEquals(1, virtualMachine.userAssignedManagedServiceIdentityIds().size());
        Assertions.assertNotNull(virtualMachine.managedServiceIdentityType());
        Assertions.assertTrue(
            virtualMachine.managedServiceIdentityType().equals(ResourceIdentityType.SYSTEM_ASSIGNED_USER_ASSIGNED));
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityPrincipalId());
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityTenantId());
        // Remove identities one by one (second one)
        virtualMachine.update().withoutUserAssignedManagedServiceIdentity(itr.next()).apply();
        //
        Assertions.assertEquals(0, virtualMachine.userAssignedManagedServiceIdentityIds().size());
        Assertions.assertNotNull(virtualMachine.managedServiceIdentityType());
        Assertions.assertTrue(virtualMachine.managedServiceIdentityType().equals(ResourceIdentityType.SYSTEM_ASSIGNED));
        //
    }

    @Test
    @DoNotRecord(skipInPlayback = true)
    public void canCreateVirtualMachineWithLMSIAndEMSI() {
        // LiveOnly because "test timing out after latest test proxy update"
        rgName = generateRandomResourceName("java-emsi-c-rg", 15);
        String identityName1 = generateRandomResourceName("msi-id", 15);
        String networkName = generateRandomResourceName("nw", 10);

        // Create a resource group
        //
        ResourceGroup resourceGroup = resourceManager.resourceGroups().define(rgName).withRegion(region).create();

        // Create a virtual network
        //
        Network network = networkManager.networks()
            .define(networkName)
            .withRegion(region)
            .withExistingResourceGroup(resourceGroup)
            .create();

        // Prepare a definition for yet-to-be-created "User Assigned (External) MSI" with contributor access to the
        // resource group
        // it resides
        //
        Creatable<Identity> creatableIdentity = msiManager.identities()
            .define(identityName1)
            .withRegion(region)
            .withExistingResourceGroup(resourceGroup)
            .withAccessToCurrentResourceGroup(BuiltInRole.CONTRIBUTOR);

        // Create a virtual machine and associate it with existing and yet-to-be-created identities
        //
        VirtualMachine virtualMachine = computeManager.virtualMachines()
            .define(vmName)
            .withRegion(region)
            .withNewResourceGroup(rgName)
            .withNewPrimaryNetwork("10.0.0.0/28")
            .withPrimaryPrivateIPAddressDynamic()
            .withoutPrimaryPublicIPAddress()
            .withPopularLinuxImage(KnownLinuxVirtualMachineImage.UBUNTU_SERVER_16_04_LTS)
            .withRootUsername("Foo12")
            .withSsh(sshPublicKey())
            .withSystemAssignedManagedServiceIdentity()
            .withSystemAssignedIdentityBasedAccessTo(network.id(), BuiltInRole.CONTRIBUTOR)
            .withNewUserAssignedManagedServiceIdentity(creatableIdentity)
            .withSize(VirtualMachineSizeTypes.STANDARD_A0)
            .create();

        Assertions.assertNotNull(virtualMachine);
        Assertions.assertNotNull(virtualMachine.innerModel());
        Assertions.assertTrue(virtualMachine.isManagedServiceIdentityEnabled());
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityPrincipalId());
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityTenantId());

        // Ensure the "User Assigned (External) MSI" id can be retrieved from the virtual machine
        //
        Set<String> emsiIds = virtualMachine.userAssignedManagedServiceIdentityIds();
        Assertions.assertNotNull(emsiIds);
        Assertions.assertEquals(1, emsiIds.size());

        Identity identity = msiManager.identities().getById(emsiIds.iterator().next());
        Assertions.assertNotNull(identity);
        Assertions.assertTrue(identity.name().equalsIgnoreCase(identityName1));

        // Ensure expected role assignment exists for LMSI
        //
        PagedIterable<RoleAssignment> roleAssignmentsForNetwork
            = this.msiManager.authorizationManager().roleAssignments().listByScope(network.id());

        boolean found = false;
        for (RoleAssignment roleAssignment : roleAssignmentsForNetwork) {
            if (roleAssignment.principalId() != null
                && roleAssignment.principalId()
                    .equalsIgnoreCase(virtualMachine.systemAssignedManagedServiceIdentityPrincipalId())) {
                found = true;
                break;
            }
        }
        Assertions.assertTrue(found, "Expected role assignment not found for the virtual network for local identity"
            + virtualMachine.systemAssignedManagedServiceIdentityPrincipalId());

        RoleAssignment assignment = lookupRoleAssignmentUsingScopeAndRoleAsync(network.id(), BuiltInRole.CONTRIBUTOR,
            virtualMachine.systemAssignedManagedServiceIdentityPrincipalId()).block();

        Assertions.assertNotNull(assignment,
            "Expected role assignment with ROLE not found for the virtual network for system assigned identity");

        // Ensure expected role assignment exists for EMSI
        //
        ResourceGroup resourceGroup1 = resourceManager.resourceGroups().getByName(virtualMachine.resourceGroupName());

        PagedIterable<RoleAssignment> roleAssignmentsForResourceGroup
            = this.msiManager.authorizationManager().roleAssignments().listByScope(resourceGroup1.id());
        found = false;
        for (RoleAssignment roleAssignment : roleAssignmentsForResourceGroup) {
            if (roleAssignment.principalId() != null
                && roleAssignment.principalId().equalsIgnoreCase(identity.principalId())) {
                found = true;
                break;
            }
        }
        Assertions.assertTrue(found,
            "Expected role assignment not found for the resource group for identity" + identity.name());

        assignment = lookupRoleAssignmentUsingScopeAndRoleAsync(resourceGroup1.id(), BuiltInRole.CONTRIBUTOR,
            identity.principalId()).block();

        Assertions.assertNotNull(assignment,
            "Expected role assignment with ROLE not found for the resource group for system assigned identity");
    }

    @Test
    @DoNotRecord(skipInPlayback = true)
    public void canUpdateVirtualMachineWithEMSIAndLMSI() throws Exception {
        rgName = generateRandomResourceName("java-emsi-c-rg", 15);
        String identityName1 = generateRandomResourceName("msi-id-1", 15);
        String identityName2 = generateRandomResourceName("msi-id-2", 15);

        // Create a virtual machine with no EMSI & LMSI
        //
        VirtualMachine virtualMachine = computeManager.virtualMachines()
            .define(vmName)
            .withRegion(region)
            .withNewResourceGroup(rgName)
            .withNewPrimaryNetwork("10.0.0.0/28")
            .withPrimaryPrivateIPAddressDynamic()
            .withoutPrimaryPublicIPAddress()
            .withPopularLinuxImage(KnownLinuxVirtualMachineImage.UBUNTU_SERVER_16_04_LTS)
            .withRootUsername("Foo12")
            .withSsh(sshPublicKey())
            .withSize(VirtualMachineSizeTypes.STANDARD_A0)
            .create();

        // Prepare a definition for yet-to-be-created "User Assigned (External) MSI" with contributor access to the
        // resource group
        // it resides
        //
        Creatable<Identity> creatableIdentity = msiManager.identities()
            .define(identityName1)
            .withRegion(region)
            .withExistingResourceGroup(virtualMachine.resourceGroupName())
            .withAccessToCurrentResourceGroup(BuiltInRole.CONTRIBUTOR);

        // Update virtual machine so that it depends on the EMSI
        //
        virtualMachine = virtualMachine.update().withNewUserAssignedManagedServiceIdentity(creatableIdentity).apply();

        // Ensure the "User Assigned (External) MSI" id can be retrieved from the virtual machine
        //
        Set<String> emsiIds = virtualMachine.userAssignedManagedServiceIdentityIds();
        Assertions.assertNotNull(emsiIds);
        Optional<String> emsiIdOptional
            = emsiIds.stream().filter(emsiId -> emsiId.endsWith("/" + identityName1)).findAny();
        Assertions.assertTrue(emsiIdOptional.isPresent());

        Identity identity = msiManager.identities().getById(emsiIdOptional.get());
        Assertions.assertNotNull(identity);
        Assertions.assertTrue(identity.name().equalsIgnoreCase(identityName1));

        // Update VM without modify MSI
        virtualMachine.update().withNewDataDisk(10).apply();
        emsiIds = virtualMachine.userAssignedManagedServiceIdentityIds();
        Assertions.assertNotNull(emsiIds);
        Assertions.assertEquals(1, emsiIds.size());

        // Creates an EMSI
        //
        Identity createdIdentity = msiManager.identities()
            .define(identityName2)
            .withRegion(region)
            .withExistingResourceGroup(virtualMachine.resourceGroupName())
            .withAccessToCurrentResourceGroup(BuiltInRole.CONTRIBUTOR)
            .create();

        // Update the virtual machine by removing the an EMSI and adding existing EMSI
        //
        virtualMachine = virtualMachine.update()
            .withoutUserAssignedManagedServiceIdentity(identity.id())
            .withExistingUserAssignedManagedServiceIdentity(createdIdentity)
            .apply();

        // Ensure the "User Assigned (External) MSI" id can be retrieved from the virtual machine
        //
        emsiIds = virtualMachine.userAssignedManagedServiceIdentityIds();
        Assertions.assertNotNull(emsiIds);
        emsiIdOptional = emsiIds.stream().filter(emsiId -> emsiId.endsWith("/" + identityName2)).findAny();
        Assertions.assertTrue(emsiIdOptional.isPresent());
        Assertions.assertFalse(emsiIds.contains(identity.id()));

        identity = msiManager.identities().getById(emsiIdOptional.get());
        Assertions.assertNotNull(identity);
        Assertions.assertTrue(identity.name().equalsIgnoreCase(identityName2));

        // Update the virtual machine by enabling "LMSI"

        virtualMachine.update().withSystemAssignedManagedServiceIdentity().apply();
        //
        Assertions.assertNotNull(virtualMachine);
        Assertions.assertNotNull(virtualMachine.innerModel());
        Assertions.assertTrue(virtualMachine.isManagedServiceIdentityEnabled());
        Assertions.assertNotNull(virtualMachine.managedServiceIdentityType());
        Assertions.assertTrue(
            virtualMachine.managedServiceIdentityType().equals(ResourceIdentityType.SYSTEM_ASSIGNED_USER_ASSIGNED));
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityPrincipalId());
        Assertions.assertNotNull(virtualMachine.systemAssignedManagedServiceIdentityTenantId());
        Assertions.assertTrue(virtualMachine.userAssignedManagedServiceIdentityIds().contains(identity.id()));
        //
        virtualMachine.update().withoutSystemAssignedManagedServiceIdentity().apply();

        Assertions.assertTrue(virtualMachine.isManagedServiceIdentityEnabled());
        Assertions.assertNotNull(virtualMachine.managedServiceIdentityType());
        // subscription policy will ensure a LMSI and a built-in EMSI
        //        Assertions.assertTrue(virtualMachine.managedServiceIdentityType().equals(ResourceIdentityType.USER_ASSIGNED));
        //        Assertions.assertNull(virtualMachine.systemAssignedManagedServiceIdentityPrincipalId());
        //        Assertions.assertNull(virtualMachine.systemAssignedManagedServiceIdentityTenantId());
        Assertions.assertTrue(virtualMachine.userAssignedManagedServiceIdentityIds().contains(identity.id()));
        //
        virtualMachine.update().withoutUserAssignedManagedServiceIdentity(identity.id()).apply();

        // subscription policy will ensure a LMSI and a built-in EMSI
        Assertions.assertFalse(virtualMachine.userAssignedManagedServiceIdentityIds().contains(identity.id()));
    }

    private Mono<RoleAssignment> lookupRoleAssignmentUsingScopeAndRoleAsync(final String scope, BuiltInRole role,
        final String principalId) {
        return this.msiManager.authorizationManager()
            .roleDefinitions()
            .getByScopeAndRoleNameAsync(scope, role.toString())
            .flatMap(roleDefinition -> msiManager.authorizationManager()
                .roleAssignments()
                .listByScopeAsync(scope)
                .filter(roleAssignment -> roleAssignment.roleDefinitionId().equalsIgnoreCase(roleDefinition.id())
                    && roleAssignment.principalId().equalsIgnoreCase(principalId))
                .singleOrEmpty())
            .switchIfEmpty(Mono.defer(() -> Mono.empty()));
    }
}
