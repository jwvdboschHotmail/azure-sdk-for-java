// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.resourcemanager.networkcloud.models.AdministrativeCredentials;
import com.azure.resourcemanager.networkcloud.models.AnalyticsOutputSettings;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineConfigurationData;
import com.azure.resourcemanager.networkcloud.models.ClusterType;
import com.azure.resourcemanager.networkcloud.models.ClusterUpdateStrategy;
import com.azure.resourcemanager.networkcloud.models.ClusterUpdateStrategyType;
import com.azure.resourcemanager.networkcloud.models.CommandOutputSettings;
import com.azure.resourcemanager.networkcloud.models.ExtendedLocation;
import com.azure.resourcemanager.networkcloud.models.IdentitySelector;
import com.azure.resourcemanager.networkcloud.models.ManagedResourceGroupConfiguration;
import com.azure.resourcemanager.networkcloud.models.ManagedServiceIdentity;
import com.azure.resourcemanager.networkcloud.models.ManagedServiceIdentitySelectorType;
import com.azure.resourcemanager.networkcloud.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.networkcloud.models.RackDefinition;
import com.azure.resourcemanager.networkcloud.models.RuntimeProtectionConfiguration;
import com.azure.resourcemanager.networkcloud.models.RuntimeProtectionEnforcementLevel;
import com.azure.resourcemanager.networkcloud.models.SecretArchiveSettings;
import com.azure.resourcemanager.networkcloud.models.ServicePrincipalInformation;
import com.azure.resourcemanager.networkcloud.models.StorageApplianceConfigurationData;
import com.azure.resourcemanager.networkcloud.models.UserAssignedIdentity;
import com.azure.resourcemanager.networkcloud.models.ValidationThreshold;
import com.azure.resourcemanager.networkcloud.models.ValidationThresholdGrouping;
import com.azure.resourcemanager.networkcloud.models.ValidationThresholdType;
import com.azure.resourcemanager.networkcloud.models.VulnerabilityScanningSettings;
import com.azure.resourcemanager.networkcloud.models.VulnerabilityScanningSettingsContainerScan;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for Clusters CreateOrUpdate.
 */
public final class ClustersCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/networkcloud/resource-manager/Microsoft.NetworkCloud/stable/2025-02-01/examples/Clusters_Create.
     * json
     */
    /**
     * Sample code: Create or update cluster.
     * 
     * @param manager Entry point to NetworkCloudManager.
     */
    public static void createOrUpdateCluster(com.azure.resourcemanager.networkcloud.NetworkCloudManager manager) {
        manager.clusters()
            .define("clusterName")
            .withRegion("location")
            .withExistingResourceGroup("resourceGroupName")
            .withExtendedLocation(new ExtendedLocation().withName(
                "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/Microsoft.ExtendedLocation/customLocations/clusterManagerExtendedLocationName")
                .withType("CustomLocation"))
            .withAggregatorOrSingleRackDefinition(
                new RackDefinition()
                    .withBareMetalMachineConfigurationData(Arrays.asList(
                        new BareMetalMachineConfigurationData()
                            .withBmcCredentials(new AdministrativeCredentials().withPassword("fakeTokenPlaceholder")
                                .withUsername("username"))
                            .withBmcMacAddress("AA:BB:CC:DD:EE:FF")
                            .withBootMacAddress("00:BB:CC:DD:EE:FF")
                            .withMachineDetails("extraDetails")
                            .withMachineName("bmmName1")
                            .withRackSlot(1L)
                            .withSerialNumber("BM1219XXX"),
                        new BareMetalMachineConfigurationData()
                            .withBmcCredentials(
                                new AdministrativeCredentials()
                                    .withPassword("fakeTokenPlaceholder")
                                    .withUsername("username"))
                            .withBmcMacAddress("AA:BB:CC:DD:EE:00")
                            .withBootMacAddress("00:BB:CC:DD:EE:00")
                            .withMachineDetails("extraDetails")
                            .withMachineName("bmmName2")
                            .withRackSlot(2L)
                            .withSerialNumber("BM1219YYY")))
                    .withNetworkRackId(
                        "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/Microsoft.ManagedNetworkFabric/networkRacks/networkRackName")
                    .withRackLocation("Foo Datacenter, Floor 3, Aisle 9, Rack 2")
                    .withRackSerialNumber("AA1234")
                    .withRackSkuId(
                        "/subscriptions/123e4567-e89b-12d3-a456-426655440000/providers/Microsoft.NetworkCloud/rackSkus/rackSkuName")
                    .withStorageApplianceConfigurationData(Arrays.asList(new StorageApplianceConfigurationData()
                        .withAdminCredentials(new AdministrativeCredentials().withPassword("fakeTokenPlaceholder")
                            .withUsername("username"))
                        .withRackSlot(1L)
                        .withSerialNumber("BM1219XXX")
                        .withStorageApplianceName("vmName"))))
            .withClusterType(ClusterType.SINGLE_RACK)
            .withClusterVersion("1.0.0")
            .withNetworkFabricId(
                "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/Microsoft.ManagedNetworkFabric/networkFabrics/fabricName")
            .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder"))
            .withIdentity(new ManagedServiceIdentity().withType(ManagedServiceIdentityType.USER_ASSIGNED)
                .withUserAssignedIdentities(mapOf(
                    "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/Microsoft.ManagedIdentity/userAssignedIdentities/userIdentity1",
                    new UserAssignedIdentity())))
            .withAnalyticsOutputSettings(new AnalyticsOutputSettings().withAnalyticsWorkspaceId(
                "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/microsoft.operationalInsights/workspaces/logAnalyticsWorkspaceName")
                .withAssociatedIdentity(new IdentitySelector()
                    .withIdentityType(ManagedServiceIdentitySelectorType.USER_ASSIGNED_IDENTITY)
                    .withUserAssignedIdentityResourceId(
                        "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/Microsoft.ManagedIdentity/userAssignedIdentities/userIdentity1")))
            .withClusterLocation("Foo Street, 3rd Floor, row 9")
            .withClusterServicePrincipal(
                new ServicePrincipalInformation().withApplicationId("12345678-1234-1234-1234-123456789012")
                    .withPassword("fakeTokenPlaceholder")
                    .withPrincipalId("00000008-0004-0004-0004-000000000012")
                    .withTenantId("80000000-4000-4000-4000-120000000000"))
            .withCommandOutputSettings(new CommandOutputSettings().withAssociatedIdentity(new IdentitySelector()
                .withIdentityType(ManagedServiceIdentitySelectorType.USER_ASSIGNED_IDENTITY)
                .withUserAssignedIdentityResourceId(
                    "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/Microsoft.ManagedIdentity/userAssignedIdentities/userIdentity1"))
                .withContainerUrl("https://myaccount.blob.core.windows.net/mycontainer?restype=container"))
            .withComputeDeploymentThreshold(
                new ValidationThreshold().withGrouping(ValidationThresholdGrouping.PER_CLUSTER)
                    .withType(ValidationThresholdType.PERCENT_SUCCESS)
                    .withValue(90L))
            .withComputeRackDefinitions(Arrays.asList(new RackDefinition()
                .withBareMetalMachineConfigurationData(Arrays.asList(
                    new BareMetalMachineConfigurationData()
                        .withBmcCredentials(new AdministrativeCredentials().withPassword("fakeTokenPlaceholder")
                            .withUsername("username"))
                        .withBmcMacAddress("AA:BB:CC:DD:EE:FF")
                        .withBootMacAddress("00:BB:CC:DD:EE:FF")
                        .withMachineDetails("extraDetails")
                        .withMachineName("bmmName1")
                        .withRackSlot(1L)
                        .withSerialNumber("BM1219XXX"),
                    new BareMetalMachineConfigurationData()
                        .withBmcCredentials(new AdministrativeCredentials().withPassword("fakeTokenPlaceholder")
                            .withUsername("username"))
                        .withBmcMacAddress("AA:BB:CC:DD:EE:00")
                        .withBootMacAddress("00:BB:CC:DD:EE:00")
                        .withMachineDetails("extraDetails")
                        .withMachineName("bmmName2")
                        .withRackSlot(2L)
                        .withSerialNumber("BM1219YYY")))
                .withNetworkRackId(
                    "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/Microsoft.ManagedNetworkFabric/networkRacks/networkRackName")
                .withRackLocation("Foo Datacenter, Floor 3, Aisle 9, Rack 2")
                .withRackSerialNumber("AA1234")
                .withRackSkuId(
                    "/subscriptions/123e4567-e89b-12d3-a456-426655440000/providers/Microsoft.NetworkCloud/rackSkus/rackSkuName")
                .withStorageApplianceConfigurationData(Arrays.asList(new StorageApplianceConfigurationData()
                    .withAdminCredentials(
                        new AdministrativeCredentials().withPassword("fakeTokenPlaceholder").withUsername("username"))
                    .withRackSlot(1L)
                    .withSerialNumber("BM1219XXX")
                    .withStorageApplianceName("vmName")))))
            .withManagedResourceGroupConfiguration(
                new ManagedResourceGroupConfiguration().withLocation("East US").withName("my-managed-rg"))
            .withRuntimeProtectionConfiguration(
                new RuntimeProtectionConfiguration().withEnforcementLevel(RuntimeProtectionEnforcementLevel.ON_DEMAND))
            .withSecretArchiveSettings(new SecretArchiveSettings().withAssociatedIdentity(new IdentitySelector()
                .withIdentityType(ManagedServiceIdentitySelectorType.USER_ASSIGNED_IDENTITY)
                .withUserAssignedIdentityResourceId(
                    "/subscriptions/123e4567-e89b-12d3-a456-426655440000/resourceGroups/resourceGroupName/providers/Microsoft.ManagedIdentity/userAssignedIdentities/userIdentity1"))
                .withVaultUri("https://keyvaultname.vault.azure.net/"))
            .withUpdateStrategy(new ClusterUpdateStrategy().withMaxUnavailable(4L)
                .withStrategyType(ClusterUpdateStrategyType.RACK)
                .withThresholdType(ValidationThresholdType.COUNT_SUCCESS)
                .withThresholdValue(4L)
                .withWaitTimeMinutes(10L))
            .withVulnerabilityScanningSettings(new VulnerabilityScanningSettings()
                .withContainerScan(VulnerabilityScanningSettingsContainerScan.ENABLED))
            .create();
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
