// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.msi.generated;

import com.azure.resourcemanager.msi.fluent.models.IdentityInner;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for UserAssignedIdentities CreateOrUpdate.
 */
public final class UserAssignedIdentitiesCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/msi/resource-manager/Microsoft.ManagedIdentity/stable/2024-11-30/examples/IdentityCreate.json
     */
    /**
     * Sample code: IdentityCreate.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void identityCreate(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.identities()
            .manager()
            .serviceClient()
            .getUserAssignedIdentities()
            .createOrUpdateWithResponse("rgName", "resourceName",
                new IdentityInner().withLocation("eastus")
                    .withTags(mapOf("key1", "fakeTokenPlaceholder", "key2", "fakeTokenPlaceholder")),
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
