// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Execution, display, or stream outputs.
 */
public final class CellOutputType extends ExpandableStringEnum<CellOutputType> {
    /**
     * Static value execute_result for CellOutputType.
     */
    @Generated
    public static final CellOutputType EXECUTE_RESULT = fromString("execute_result");

    /**
     * Static value display_data for CellOutputType.
     */
    @Generated
    public static final CellOutputType DISPLAY_DATA = fromString("display_data");

    /**
     * Static value stream for CellOutputType.
     */
    @Generated
    public static final CellOutputType STREAM = fromString("stream");

    /**
     * Static value error for CellOutputType.
     */
    @Generated
    public static final CellOutputType ERROR = fromString("error");

    /**
     * Creates a new instance of CellOutputType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public CellOutputType() {
    }

    /**
     * Creates or finds a CellOutputType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding CellOutputType.
     */
    @Generated
    public static CellOutputType fromString(String name) {
        return fromString(name, CellOutputType.class);
    }

    /**
     * Gets known CellOutputType values.
     * 
     * @return known CellOutputType values.
     */
    @Generated
    public static Collection<CellOutputType> values() {
        return values(CellOutputType.class);
    }
}
