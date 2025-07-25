// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hardwaresecuritymodules.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Provisioning state.
 */
public final class JsonWebKeyType extends ExpandableStringEnum<JsonWebKeyType> {
    /**
     * The dedicated HSM has been fully provisioned.
     */
    public static final JsonWebKeyType SUCCEEDED = fromString("Succeeded");

    /**
     * The dedicated HSM is currently being provisioned.
     */
    public static final JsonWebKeyType PROVISIONING = fromString("Provisioning");

    /**
     * A device is currently being allocated for the dedicated HSM resource.
     */
    public static final JsonWebKeyType ALLOCATING = fromString("Allocating");

    /**
     * The dedicated HSM is being connected to the virtual network.
     */
    public static final JsonWebKeyType CONNECTING = fromString("Connecting");

    /**
     * Provisioning of the dedicated HSM has failed.
     */
    public static final JsonWebKeyType FAILED = fromString("Failed");

    /**
     * Validating the subscription has sufficient quota to allocate a dedicated HSM device.
     */
    public static final JsonWebKeyType CHECKING_QUOTA = fromString("CheckingQuota");

    /**
     * The dedicated HSM is currently being deleted.
     */
    public static final JsonWebKeyType DELETING = fromString("Deleting");

    /**
     * Creates a new instance of JsonWebKeyType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public JsonWebKeyType() {
    }

    /**
     * Creates or finds a JsonWebKeyType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding JsonWebKeyType.
     */
    public static JsonWebKeyType fromString(String name) {
        return fromString(name, JsonWebKeyType.class);
    }

    /**
     * Gets known JsonWebKeyType values.
     * 
     * @return known JsonWebKeyType values.
     */
    public static Collection<JsonWebKeyType> values() {
        return values(JsonWebKeyType.class);
    }
}
