// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

/**
 * Samples for Volumes ReplicationStatus.
 */
public final class VolumesReplicationStatusSamples {
    /*
     * x-ms-original-file:
     * specification/netapp/resource-manager/Microsoft.NetApp/stable/2025-03-01/examples/Volumes_ReplicationStatus.json
     */
    /**
     * Sample code: Volumes_ReplicationStatus.
     * 
     * @param manager Entry point to NetAppFilesManager.
     */
    public static void volumesReplicationStatus(com.azure.resourcemanager.netapp.NetAppFilesManager manager) {
        manager.volumes()
            .replicationStatusWithResponse("myRG", "account1", "pool1", "volume1", com.azure.core.util.Context.NONE);
    }
}
