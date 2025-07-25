// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

/**
 * Samples for NetworkSecurityPerimeterConfigurations Get.
 */
public final class NetworkSecurityPerimeterConfigurationsGetSamples {
    /*
     * x-ms-original-file:
     * specification/cognitiveservices/resource-manager/Microsoft.CognitiveServices/stable/2025-06-01/examples/
     * GetNetworkSecurityPerimeterConfigurations.json
     */
    /**
     * Sample code: GetNetworkSecurityPerimeterConfigurations.
     * 
     * @param manager Entry point to CognitiveServicesManager.
     */
    public static void getNetworkSecurityPerimeterConfigurations(
        com.azure.resourcemanager.cognitiveservices.CognitiveServicesManager manager) {
        manager.networkSecurityPerimeterConfigurations()
            .getWithResponse("resourceGroupName", "accountName", "NSPConfigurationName",
                com.azure.core.util.Context.NONE);
    }
}
