// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dnsresolver.models;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.dnsresolver.fluent.models.DnsResolverDomainListInner;
import java.util.List;
import java.util.Map;

/**
 * An immutable client-side representation of DnsResolverDomainList.
 */
public interface DnsResolverDomainList {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     * 
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the etag property: ETag of the DNS resolver domain list.
     * 
     * @return the etag value.
     */
    String etag();

    /**
     * Gets the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the domains property: The domains in the domain list. Will be null if user is using large domain list.
     * 
     * @return the domains value.
     */
    List<String> domains();

    /**
     * Gets the domainsUrl property: The URL for bulk upload or download for domain lists containing larger set of
     * domains. This will be populated if domains is empty or null.
     * 
     * @return the domainsUrl value.
     */
    String domainsUrl();

    /**
     * Gets the provisioningState property: The current provisioning state of the DNS resolver domain list. This is a
     * read-only property and any attempt to set this value will be ignored.
     * 
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * Gets the resourceGuid property: The resourceGuid property of the DNS resolver domain list resource.
     * 
     * @return the resourceGuid value.
     */
    String resourceGuid();

    /**
     * Gets the region of the resource.
     * 
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     * 
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.dnsresolver.fluent.models.DnsResolverDomainListInner object.
     * 
     * @return the inner object.
     */
    DnsResolverDomainListInner innerModel();

    /**
     * The entirety of the DnsResolverDomainList definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithLocation,
        DefinitionStages.WithResourceGroup, DefinitionStages.WithCreate {
    }

    /**
     * The DnsResolverDomainList definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the DnsResolverDomainList definition.
         */
        interface Blank extends WithLocation {
        }

        /**
         * The stage of the DnsResolverDomainList definition allowing to specify location.
         */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }

        /**
         * The stage of the DnsResolverDomainList definition allowing to specify parent resource.
         */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             * 
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @return the next definition stage.
             */
            WithCreate withExistingResourceGroup(String resourceGroupName);
        }

        /**
         * The stage of the DnsResolverDomainList definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithTags, DefinitionStages.WithDomains,
            DefinitionStages.WithIfMatch, DefinitionStages.WithIfNoneMatch {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            DnsResolverDomainList create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            DnsResolverDomainList create(Context context);
        }

        /**
         * The stage of the DnsResolverDomainList definition allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             * 
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }

        /**
         * The stage of the DnsResolverDomainList definition allowing to specify domains.
         */
        interface WithDomains {
            /**
             * Specifies the domains property: The domains in the domain list. Will be null if user is using large
             * domain list..
             * 
             * @param domains The domains in the domain list. Will be null if user is using large domain list.
             * @return the next definition stage.
             */
            WithCreate withDomains(List<String> domains);
        }

        /**
         * The stage of the DnsResolverDomainList definition allowing to specify ifMatch.
         */
        interface WithIfMatch {
            /**
             * Specifies the ifMatch property: ETag of the resource. Omit this value to always overwrite the current
             * resource. Specify the last-seen ETag value to prevent accidentally overwriting any concurrent changes..
             * 
             * @param ifMatch ETag of the resource. Omit this value to always overwrite the current resource. Specify
             * the last-seen ETag value to prevent accidentally overwriting any concurrent changes.
             * @return the next definition stage.
             */
            WithCreate withIfMatch(String ifMatch);
        }

        /**
         * The stage of the DnsResolverDomainList definition allowing to specify ifNoneMatch.
         */
        interface WithIfNoneMatch {
            /**
             * Specifies the ifNoneMatch property: Set to '*' to allow a new resource to be created, but to prevent
             * updating an existing resource. Other values will be ignored..
             * 
             * @param ifNoneMatch Set to '*' to allow a new resource to be created, but to prevent updating an existing
             * resource. Other values will be ignored.
             * @return the next definition stage.
             */
            WithCreate withIfNoneMatch(String ifNoneMatch);
        }
    }

    /**
     * Begins update for the DnsResolverDomainList resource.
     * 
     * @return the stage of resource update.
     */
    DnsResolverDomainList.Update update();

    /**
     * The template for DnsResolverDomainList update.
     */
    interface Update extends UpdateStages.WithTags, UpdateStages.WithDomains, UpdateStages.WithIfMatch {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        DnsResolverDomainList apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        DnsResolverDomainList apply(Context context);
    }

    /**
     * The DnsResolverDomainList update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the DnsResolverDomainList update allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Tags for DNS resolver domain list..
             * 
             * @param tags Tags for DNS resolver domain list.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }

        /**
         * The stage of the DnsResolverDomainList update allowing to specify domains.
         */
        interface WithDomains {
            /**
             * Specifies the domains property: The domains in the domain list..
             * 
             * @param domains The domains in the domain list.
             * @return the next definition stage.
             */
            Update withDomains(List<String> domains);
        }

        /**
         * The stage of the DnsResolverDomainList update allowing to specify ifMatch.
         */
        interface WithIfMatch {
            /**
             * Specifies the ifMatch property: ETag of the resource. Omit this value to always overwrite the current
             * resource. Specify the last-seen ETag value to prevent accidentally overwriting any concurrent changes..
             * 
             * @param ifMatch ETag of the resource. Omit this value to always overwrite the current resource. Specify
             * the last-seen ETag value to prevent accidentally overwriting any concurrent changes.
             * @return the next definition stage.
             */
            Update withIfMatch(String ifMatch);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    DnsResolverDomainList refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    DnsResolverDomainList refresh(Context context);

    /**
     * Uploads or downloads the list of domains for a DNS Resolver Domain List from a storage link.
     * 
     * @param parameters Parameters supplied to the bulk domain list operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes a DNS resolver domain list.
     */
    DnsResolverDomainList bulk(DnsResolverDomainListBulk parameters);

    /**
     * Uploads or downloads the list of domains for a DNS Resolver Domain List from a storage link.
     * 
     * @param parameters Parameters supplied to the bulk domain list operation.
     * @param ifMatch ETag of the resource. Omit this value to always overwrite the current resource. Specify the
     * last-seen ETag value to prevent accidentally overwriting any concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new resource to be created, but to prevent updating an existing
     * resource. Other values will be ignored.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return describes a DNS resolver domain list.
     */
    DnsResolverDomainList bulk(DnsResolverDomainListBulk parameters, String ifMatch, String ifNoneMatch,
        Context context);
}
