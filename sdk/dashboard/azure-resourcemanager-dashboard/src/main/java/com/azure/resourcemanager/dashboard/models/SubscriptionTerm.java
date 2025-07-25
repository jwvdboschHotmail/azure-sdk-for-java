// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dashboard.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The current billing term of the SaaS Subscription.
 */
@Immutable
public final class SubscriptionTerm implements JsonSerializable<SubscriptionTerm> {
    /*
     * The unit of the billing term.
     */
    private String termUnit;

    /*
     * The date and time in UTC of when the billing term starts.
     */
    private OffsetDateTime startDate;

    /*
     * The date and time in UTC of when the billing term ends.
     */
    private OffsetDateTime endDate;

    /**
     * Creates an instance of SubscriptionTerm class.
     */
    private SubscriptionTerm() {
    }

    /**
     * Get the termUnit property: The unit of the billing term.
     * 
     * @return the termUnit value.
     */
    public String termUnit() {
        return this.termUnit;
    }

    /**
     * Get the startDate property: The date and time in UTC of when the billing term starts.
     * 
     * @return the startDate value.
     */
    public OffsetDateTime startDate() {
        return this.startDate;
    }

    /**
     * Get the endDate property: The date and time in UTC of when the billing term ends.
     * 
     * @return the endDate value.
     */
    public OffsetDateTime endDate() {
        return this.endDate;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("termUnit", this.termUnit);
        jsonWriter.writeStringField("startDate",
            this.startDate == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.startDate));
        jsonWriter.writeStringField("endDate",
            this.endDate == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.endDate));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SubscriptionTerm from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SubscriptionTerm if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the SubscriptionTerm.
     */
    public static SubscriptionTerm fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SubscriptionTerm deserializedSubscriptionTerm = new SubscriptionTerm();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("termUnit".equals(fieldName)) {
                    deserializedSubscriptionTerm.termUnit = reader.getString();
                } else if ("startDate".equals(fieldName)) {
                    deserializedSubscriptionTerm.startDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("endDate".equals(fieldName)) {
                    deserializedSubscriptionTerm.endDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSubscriptionTerm;
        });
    }
}
