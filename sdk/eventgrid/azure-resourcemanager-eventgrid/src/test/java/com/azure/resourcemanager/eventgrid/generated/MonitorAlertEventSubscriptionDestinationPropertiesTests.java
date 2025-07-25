// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.fluent.models.MonitorAlertEventSubscriptionDestinationProperties;
import com.azure.resourcemanager.eventgrid.models.MonitorAlertSeverity;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class MonitorAlertEventSubscriptionDestinationPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MonitorAlertEventSubscriptionDestinationProperties model = BinaryData.fromString(
            "{\"severity\":\"Sev2\",\"description\":\"ye\",\"actionGroups\":[\"unaucm\",\"irtneemmjau\",\"cgxefnohaitraniz\"]}")
            .toObject(MonitorAlertEventSubscriptionDestinationProperties.class);
        Assertions.assertEquals(MonitorAlertSeverity.SEV2, model.severity());
        Assertions.assertEquals("ye", model.description());
        Assertions.assertEquals("unaucm", model.actionGroups().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MonitorAlertEventSubscriptionDestinationProperties model
            = new MonitorAlertEventSubscriptionDestinationProperties().withSeverity(MonitorAlertSeverity.SEV2)
                .withDescription("ye")
                .withActionGroups(Arrays.asList("unaucm", "irtneemmjau", "cgxefnohaitraniz"));
        model = BinaryData.fromObject(model).toObject(MonitorAlertEventSubscriptionDestinationProperties.class);
        Assertions.assertEquals(MonitorAlertSeverity.SEV2, model.severity());
        Assertions.assertEquals("ye", model.description());
        Assertions.assertEquals("unaucm", model.actionGroups().get(0));
    }
}
