// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The authentication type to use.
 */
public final class ZendeskAuthenticationType extends ExpandableStringEnum<ZendeskAuthenticationType> {
    /**
     * Static value Basic for ZendeskAuthenticationType.
     */
    @Generated
    public static final ZendeskAuthenticationType BASIC = fromString("Basic");

    /**
     * Static value Token for ZendeskAuthenticationType.
     */
    @Generated
    public static final ZendeskAuthenticationType TOKEN = fromString("Token");

    /**
     * Creates a new instance of ZendeskAuthenticationType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public ZendeskAuthenticationType() {
    }

    /**
     * Creates or finds a ZendeskAuthenticationType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ZendeskAuthenticationType.
     */
    @Generated
    public static ZendeskAuthenticationType fromString(String name) {
        return fromString(name, ZendeskAuthenticationType.class);
    }

    /**
     * Gets known ZendeskAuthenticationType values.
     * 
     * @return known ZendeskAuthenticationType values.
     */
    @Generated
    public static Collection<ZendeskAuthenticationType> values() {
        return values(ZendeskAuthenticationType.class);
    }
}
