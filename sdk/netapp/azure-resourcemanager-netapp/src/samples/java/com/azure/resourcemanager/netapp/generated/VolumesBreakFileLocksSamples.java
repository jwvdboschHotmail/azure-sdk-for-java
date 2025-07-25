// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.resourcemanager.netapp.models.BreakFileLocksRequest;

/**
 * Samples for Volumes BreakFileLocks.
 */
public final class VolumesBreakFileLocksSamples {
    /*
     * x-ms-original-file:
     * specification/netapp/resource-manager/Microsoft.NetApp/stable/2025-03-01/examples/Volumes_BreakFileLocks.json
     */
    /**
     * Sample code: Volumes_BreakFileLocks.
     * 
     * @param manager Entry point to NetAppFilesManager.
     */
    public static void volumesBreakFileLocks(com.azure.resourcemanager.netapp.NetAppFilesManager manager) {
        manager.volumes()
            .breakFileLocks("myRG", "account1", "pool1", "volume1",
                new BreakFileLocksRequest().withClientIp("101.102.103.104").withConfirmRunningDisruptiveOperation(true),
                com.azure.core.util.Context.NONE);
    }
}
