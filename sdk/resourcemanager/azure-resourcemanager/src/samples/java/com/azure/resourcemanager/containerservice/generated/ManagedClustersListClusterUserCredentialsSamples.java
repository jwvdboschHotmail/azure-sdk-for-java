// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.generated;

/**
 * Samples for ManagedClusters ListClusterUserCredentials.
 */
public final class ManagedClustersListClusterUserCredentialsSamples {
    /*
     * x-ms-original-file:
     * specification/containerservice/resource-manager/Microsoft.ContainerService/aks/stable/2025-05-01/examples/
     * ManagedClustersListClusterUserCredentials.json
     */
    /**
     * Sample code: Get Managed Cluster.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getManagedCluster(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.kubernetesClusters()
            .manager()
            .serviceClient()
            .getManagedClusters()
            .listClusterUserCredentialsWithResponse("rg1", "clustername1", null, null,
                com.azure.core.util.Context.NONE);
    }
}
