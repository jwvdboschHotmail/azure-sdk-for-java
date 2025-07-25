// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.models.AzureFunctionEventSubscriptionDestination;
import com.azure.resourcemanager.eventgrid.models.DeliveryAttributeMapping;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class AzureFunctionEventSubscriptionDestinationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureFunctionEventSubscriptionDestination model = BinaryData.fromString(
            "{\"endpointType\":\"AzureFunction\",\"properties\":{\"resourceId\":\"gpewq\",\"maxEventsPerBatch\":217043670,\"preferredBatchSizeInKilobytes\":1023657842,\"deliveryAttributeMappings\":[{\"type\":\"DeliveryAttributeMapping\",\"name\":\"ozglq\"},{\"type\":\"DeliveryAttributeMapping\",\"name\":\"kn\"},{\"type\":\"DeliveryAttributeMapping\",\"name\":\"clctzey\"},{\"type\":\"DeliveryAttributeMapping\",\"name\":\"mndcov\"}]}}")
            .toObject(AzureFunctionEventSubscriptionDestination.class);
        Assertions.assertEquals("gpewq", model.resourceId());
        Assertions.assertEquals(217043670, model.maxEventsPerBatch());
        Assertions.assertEquals(1023657842, model.preferredBatchSizeInKilobytes());
        Assertions.assertEquals("ozglq", model.deliveryAttributeMappings().get(0).name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureFunctionEventSubscriptionDestination model
            = new AzureFunctionEventSubscriptionDestination().withResourceId("gpewq")
                .withMaxEventsPerBatch(217043670)
                .withPreferredBatchSizeInKilobytes(1023657842)
                .withDeliveryAttributeMappings(Arrays.asList(new DeliveryAttributeMapping().withName("ozglq"),
                    new DeliveryAttributeMapping().withName("kn"), new DeliveryAttributeMapping().withName("clctzey"),
                    new DeliveryAttributeMapping().withName("mndcov")));
        model = BinaryData.fromObject(model).toObject(AzureFunctionEventSubscriptionDestination.class);
        Assertions.assertEquals("gpewq", model.resourceId());
        Assertions.assertEquals(217043670, model.maxEventsPerBatch());
        Assertions.assertEquals(1023657842, model.preferredBatchSizeInKilobytes());
        Assertions.assertEquals("ozglq", model.deliveryAttributeMappings().get(0).name());
    }
}
