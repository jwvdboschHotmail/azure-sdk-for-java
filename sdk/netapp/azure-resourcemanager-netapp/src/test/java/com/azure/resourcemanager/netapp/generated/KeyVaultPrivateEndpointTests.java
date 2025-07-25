// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.models.KeyVaultPrivateEndpoint;
import org.junit.jupiter.api.Assertions;

public final class KeyVaultPrivateEndpointTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        KeyVaultPrivateEndpoint model
            = BinaryData.fromString("{\"virtualNetworkId\":\"bzpfzab\",\"privateEndpointId\":\"cuh\"}")
                .toObject(KeyVaultPrivateEndpoint.class);
        Assertions.assertEquals("bzpfzab", model.virtualNetworkId());
        Assertions.assertEquals("cuh", model.privateEndpointId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        KeyVaultPrivateEndpoint model
            = new KeyVaultPrivateEndpoint().withVirtualNetworkId("bzpfzab").withPrivateEndpointId("cuh");
        model = BinaryData.fromObject(model).toObject(KeyVaultPrivateEndpoint.class);
        Assertions.assertEquals("bzpfzab", model.virtualNetworkId());
        Assertions.assertEquals("cuh", model.privateEndpointId());
    }
}
