// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

module com.azure.resourcemanager.servicefabricmanagedclusters {
    requires transitive com.azure.core.management;

    exports com.azure.resourcemanager.servicefabricmanagedclusters;
    exports com.azure.resourcemanager.servicefabricmanagedclusters.fluent;
    exports com.azure.resourcemanager.servicefabricmanagedclusters.fluent.models;
    exports com.azure.resourcemanager.servicefabricmanagedclusters.models;

    opens com.azure.resourcemanager.servicefabricmanagedclusters.fluent.models to com.azure.core;
    opens com.azure.resourcemanager.servicefabricmanagedclusters.models to com.azure.core;
    opens com.azure.resourcemanager.servicefabricmanagedclusters.implementation.models to com.azure.core;
}
