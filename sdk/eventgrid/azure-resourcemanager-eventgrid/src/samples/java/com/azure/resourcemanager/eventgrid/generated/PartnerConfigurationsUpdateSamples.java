// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.resourcemanager.eventgrid.models.PartnerConfigurationUpdateParameters;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for PartnerConfigurations Update.
 */
public final class PartnerConfigurationsUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/eventgrid/resource-manager/Microsoft.EventGrid/preview/2025-04-01-preview/examples/
     * PartnerConfigurations_Update.json
     */
    /**
     * Sample code: PartnerConfigurations_Update.
     * 
     * @param manager Entry point to EventGridManager.
     */
    public static void partnerConfigurationsUpdate(com.azure.resourcemanager.eventgrid.EventGridManager manager) {
        manager.partnerConfigurations()
            .update("examplerg",
                new PartnerConfigurationUpdateParameters().withTags(mapOf("tag1", "value11", "tag2", "value22"))
                    .withDefaultMaximumExpirationTimeInDays(100),
                com.azure.core.util.Context.NONE);
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
