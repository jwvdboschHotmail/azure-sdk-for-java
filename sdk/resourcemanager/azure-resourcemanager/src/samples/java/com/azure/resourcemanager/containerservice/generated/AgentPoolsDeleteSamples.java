// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.generated;

/**
 * Samples for AgentPools Delete.
 */
public final class AgentPoolsDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/containerservice/resource-manager/Microsoft.ContainerService/aks/stable/2025-05-01/examples/
     * AgentPoolsDelete.json
     */
    /**
     * Sample code: Delete Agent Pool.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void deleteAgentPool(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.kubernetesClusters()
            .manager()
            .serviceClient()
            .getAgentPools()
            .delete("rg1", "clustername1", "agentpool1", null, null, com.azure.core.util.Context.NONE);
    }
}
