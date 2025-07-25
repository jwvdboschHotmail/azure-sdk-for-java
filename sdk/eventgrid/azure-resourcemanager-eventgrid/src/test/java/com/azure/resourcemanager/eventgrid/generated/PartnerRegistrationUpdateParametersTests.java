// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.models.PartnerRegistrationUpdateParameters;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class PartnerRegistrationUpdateParametersTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PartnerRegistrationUpdateParameters model
            = BinaryData.fromString("{\"tags\":{\"zsdbccxjmon\":\"rbdkelvidiz\",\"uqj\":\"dgnwncypuuwwlt\"}}")
                .toObject(PartnerRegistrationUpdateParameters.class);
        Assertions.assertEquals("rbdkelvidiz", model.tags().get("zsdbccxjmon"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PartnerRegistrationUpdateParameters model = new PartnerRegistrationUpdateParameters()
            .withTags(mapOf("zsdbccxjmon", "rbdkelvidiz", "uqj", "dgnwncypuuwwlt"));
        model = BinaryData.fromObject(model).toObject(PartnerRegistrationUpdateParameters.class);
        Assertions.assertEquals("rbdkelvidiz", model.tags().get("zsdbccxjmon"));
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
