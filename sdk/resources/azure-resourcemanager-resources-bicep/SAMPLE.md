# Code snippets and samples


## DecompileOperationGroup

- [Bicep](#decompileoperationgroup_bicep)
### DecompileOperationGroup_Bicep

```java
import com.azure.resourcemanager.resources.bicep.models.DecompileOperationRequest;

/**
 * Samples for DecompileOperationGroup Bicep.
 */
public final class DecompileOperationGroupBicepSamples {
    /*
     * x-ms-original-file: 2023-11-01/DecompileBicep.json
     */
    /**
     * Sample code: Decompile an ARM json template into a Bicep file.
     * 
     * @param manager Entry point to BicepProviderManager.
     */
    public static void decompileAnARMJsonTemplateIntoABicepFile(
        com.azure.resourcemanager.resources.bicep.BicepProviderManager manager) {
        manager.decompileOperationGroups()
            .bicepWithResponse(new DecompileOperationRequest().withTemplate(
                "{\r\n \"$schema\": \"https://schema.management.azure.com/schemas/2019-04-01/deploymentTemplate.json#\",\r\n \"contentVersion\": \"1.0.0.0\",\r\n \"metadata\": {\r\n \"_generator\": {\r\n \"name\": \"bicep\",\r\n \"version\": \"0.15.31.15270\",\r\n \"templateHash\": \"9249505596133208719\"\r\n }\r\n },\r\n \"parameters\": {\r\n \"storageAccountName\": {\r\n \"type\": \"string\"\r\n }\r\n },\r\n \"resources\": []\r\n}"),
                com.azure.core.util.Context.NONE);
    }
}
```

