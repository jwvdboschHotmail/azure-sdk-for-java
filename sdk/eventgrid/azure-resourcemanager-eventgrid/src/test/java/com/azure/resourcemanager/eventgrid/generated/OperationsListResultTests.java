// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.fluent.models.OperationInner;
import com.azure.resourcemanager.eventgrid.models.OperationInfo;
import com.azure.resourcemanager.eventgrid.models.OperationsListResult;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class OperationsListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        OperationsListResult model = BinaryData.fromString(
            "{\"value\":[{\"name\":\"pidkqqfkuvscxkdm\",\"display\":{\"provider\":\"ovibrxkp\",\"resource\":\"oaz\",\"operation\":\"u\",\"description\":\"bgo\"},\"origin\":\"bteoybf\",\"isDataAction\":true,\"properties\":\"datakvvjgslordilmyww\"},{\"name\":\"gkxnyedabg\",\"display\":{\"provider\":\"dtj\",\"resource\":\"wbcihxuuwh\",\"operation\":\"yxccyb\",\"description\":\"ayakkudzpx\"},\"origin\":\"jplmagstcy\",\"isDataAction\":true,\"properties\":\"datakyrk\"}]}")
            .toObject(OperationsListResult.class);
        Assertions.assertEquals("pidkqqfkuvscxkdm", model.value().get(0).name());
        Assertions.assertEquals("ovibrxkp", model.value().get(0).display().provider());
        Assertions.assertEquals("oaz", model.value().get(0).display().resource());
        Assertions.assertEquals("u", model.value().get(0).display().operation());
        Assertions.assertEquals("bgo", model.value().get(0).display().description());
        Assertions.assertEquals("bteoybf", model.value().get(0).origin());
        Assertions.assertTrue(model.value().get(0).isDataAction());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        OperationsListResult model = new OperationsListResult().withValue(Arrays.asList(
            new OperationInner().withName("pidkqqfkuvscxkdm")
                .withDisplay(new OperationInfo().withProvider("ovibrxkp")
                    .withResource("oaz")
                    .withOperation("u")
                    .withDescription("bgo"))
                .withOrigin("bteoybf")
                .withIsDataAction(true)
                .withProperties("datakvvjgslordilmyww"),
            new OperationInner().withName("gkxnyedabg")
                .withDisplay(new OperationInfo().withProvider("dtj")
                    .withResource("wbcihxuuwh")
                    .withOperation("yxccyb")
                    .withDescription("ayakkudzpx"))
                .withOrigin("jplmagstcy")
                .withIsDataAction(true)
                .withProperties("datakyrk")));
        model = BinaryData.fromObject(model).toObject(OperationsListResult.class);
        Assertions.assertEquals("pidkqqfkuvscxkdm", model.value().get(0).name());
        Assertions.assertEquals("ovibrxkp", model.value().get(0).display().provider());
        Assertions.assertEquals("oaz", model.value().get(0).display().resource());
        Assertions.assertEquals("u", model.value().get(0).display().operation());
        Assertions.assertEquals("bgo", model.value().get(0).display().description());
        Assertions.assertEquals("bteoybf", model.value().get(0).origin());
        Assertions.assertTrue(model.value().get(0).isDataAction());
    }
}
