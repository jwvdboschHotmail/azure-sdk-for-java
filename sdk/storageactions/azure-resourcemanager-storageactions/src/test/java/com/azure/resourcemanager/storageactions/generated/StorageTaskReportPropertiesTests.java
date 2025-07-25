// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.storageactions.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.storageactions.models.StorageTaskReportProperties;

public final class StorageTaskReportPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        StorageTaskReportProperties model = BinaryData.fromString(
            "{\"taskAssignmentId\":\"ighxpk\",\"storageAccountId\":\"zb\",\"startTime\":\"uebbaumnyqup\",\"finishTime\":\"eojnabc\",\"objectsTargetedCount\":\"smtxpsieb\",\"objectsOperatedOnCount\":\"hvpesapskrdqm\",\"objectFailedCount\":\"jdhtldwkyzxu\",\"objectsSucceededCount\":\"kn\",\"runStatusError\":\"scwsv\",\"runStatusEnum\":\"Finished\",\"summaryReportPath\":\"ogtwrupqsxvnmi\",\"taskId\":\"kvceoveilovnotyf\",\"taskVersion\":\"cnjbkcnxdhbt\",\"runResult\":\"Succeeded\"}")
            .toObject(StorageTaskReportProperties.class);
    }
}
