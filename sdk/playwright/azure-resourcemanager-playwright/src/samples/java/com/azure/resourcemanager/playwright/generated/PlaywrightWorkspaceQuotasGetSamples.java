// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.playwright.generated;

import com.azure.resourcemanager.playwright.models.QuotaName;

/**
 * Samples for PlaywrightWorkspaceQuotas Get.
 */
public final class PlaywrightWorkspaceQuotasGetSamples {
    /*
     * x-ms-original-file: 2025-07-01-preview/PlaywrightWorkspaceQuotas_Get.json
     */
    /**
     * Sample code: PlaywrightWorkspaceQuotas_Get.
     * 
     * @param manager Entry point to PlaywrightManager.
     */
    public static void playwrightWorkspaceQuotasGet(com.azure.resourcemanager.playwright.PlaywrightManager manager) {
        manager.playwrightWorkspaceQuotas()
            .getWithResponse("dummyrg", "myWorkspace", QuotaName.EXECUTION_MINUTES, com.azure.core.util.Context.NONE);
    }
}
