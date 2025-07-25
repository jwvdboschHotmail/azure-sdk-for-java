// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Linked service for Sybase data source.
 */
@Fluent
public class SybaseLinkedService extends LinkedService {
    /*
     * Type of linked service.
     */
    @Generated
    private String type = "Sybase";

    /*
     * Server name for connection. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object server;

    /*
     * Database name for connection. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object database;

    /*
     * Schema name for connection. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object schema;

    /*
     * AuthenticationType to be used for connection.
     */
    @Generated
    private SybaseAuthenticationType authenticationType;

    /*
     * Username for authentication. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object username;

    /*
     * Password for authentication.
     */
    @Generated
    private SecretBase password;

    /*
     * The encrypted credential used for authentication. Credentials are encrypted using the integration runtime
     * credential manager. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object encryptedCredential;

    /**
     * Creates an instance of SybaseLinkedService class.
     */
    @Generated
    public SybaseLinkedService() {
    }

    /**
     * Get the type property: Type of linked service.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the server property: Server name for connection. Type: string (or Expression with resultType string).
     * 
     * @return the server value.
     */
    @Generated
    public Object getServer() {
        return this.server;
    }

    /**
     * Set the server property: Server name for connection. Type: string (or Expression with resultType string).
     * 
     * @param server the server value to set.
     * @return the SybaseLinkedService object itself.
     */
    @Generated
    public SybaseLinkedService setServer(Object server) {
        this.server = server;
        return this;
    }

    /**
     * Get the database property: Database name for connection. Type: string (or Expression with resultType string).
     * 
     * @return the database value.
     */
    @Generated
    public Object getDatabase() {
        return this.database;
    }

    /**
     * Set the database property: Database name for connection. Type: string (or Expression with resultType string).
     * 
     * @param database the database value to set.
     * @return the SybaseLinkedService object itself.
     */
    @Generated
    public SybaseLinkedService setDatabase(Object database) {
        this.database = database;
        return this;
    }

    /**
     * Get the schema property: Schema name for connection. Type: string (or Expression with resultType string).
     * 
     * @return the schema value.
     */
    @Generated
    public Object getSchema() {
        return this.schema;
    }

    /**
     * Set the schema property: Schema name for connection. Type: string (or Expression with resultType string).
     * 
     * @param schema the schema value to set.
     * @return the SybaseLinkedService object itself.
     */
    @Generated
    public SybaseLinkedService setSchema(Object schema) {
        this.schema = schema;
        return this;
    }

    /**
     * Get the authenticationType property: AuthenticationType to be used for connection.
     * 
     * @return the authenticationType value.
     */
    @Generated
    public SybaseAuthenticationType getAuthenticationType() {
        return this.authenticationType;
    }

    /**
     * Set the authenticationType property: AuthenticationType to be used for connection.
     * 
     * @param authenticationType the authenticationType value to set.
     * @return the SybaseLinkedService object itself.
     */
    @Generated
    public SybaseLinkedService setAuthenticationType(SybaseAuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
        return this;
    }

    /**
     * Get the username property: Username for authentication. Type: string (or Expression with resultType string).
     * 
     * @return the username value.
     */
    @Generated
    public Object getUsername() {
        return this.username;
    }

    /**
     * Set the username property: Username for authentication. Type: string (or Expression with resultType string).
     * 
     * @param username the username value to set.
     * @return the SybaseLinkedService object itself.
     */
    @Generated
    public SybaseLinkedService setUsername(Object username) {
        this.username = username;
        return this;
    }

    /**
     * Get the password property: Password for authentication.
     * 
     * @return the password value.
     */
    @Generated
    public SecretBase getPassword() {
        return this.password;
    }

    /**
     * Set the password property: Password for authentication.
     * 
     * @param password the password value to set.
     * @return the SybaseLinkedService object itself.
     */
    @Generated
    public SybaseLinkedService setPassword(SecretBase password) {
        this.password = password;
        return this;
    }

    /**
     * Get the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string (or Expression with resultType string).
     * 
     * @return the encryptedCredential value.
     */
    @Generated
    public Object getEncryptedCredential() {
        return this.encryptedCredential;
    }

    /**
     * Set the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string (or Expression with resultType string).
     * 
     * @param encryptedCredential the encryptedCredential value to set.
     * @return the SybaseLinkedService object itself.
     */
    @Generated
    public SybaseLinkedService setEncryptedCredential(Object encryptedCredential) {
        this.encryptedCredential = encryptedCredential;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SybaseLinkedService setVersion(String version) {
        super.setVersion(version);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SybaseLinkedService setConnectVia(IntegrationRuntimeReference connectVia) {
        super.setConnectVia(connectVia);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SybaseLinkedService setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SybaseLinkedService setParameters(Map<String, ParameterSpecification> parameters) {
        super.setParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SybaseLinkedService setAnnotations(List<Object> annotations) {
        super.setAnnotations(annotations);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("version", getVersion());
        jsonWriter.writeJsonField("connectVia", getConnectVia());
        jsonWriter.writeStringField("description", getDescription());
        jsonWriter.writeMapField("parameters", getParameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", getAnnotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeStringField("type", this.type);
        if (server != null
            || database != null
            || schema != null
            || authenticationType != null
            || username != null
            || password != null
            || encryptedCredential != null) {
            jsonWriter.writeStartObject("typeProperties");
            jsonWriter.writeUntypedField("server", this.server);
            jsonWriter.writeUntypedField("database", this.database);
            if (this.schema != null) {
                jsonWriter.writeUntypedField("schema", this.schema);
            }
            jsonWriter.writeStringField("authenticationType",
                this.authenticationType == null ? null : this.authenticationType.toString());
            if (this.username != null) {
                jsonWriter.writeUntypedField("username", this.username);
            }
            jsonWriter.writeJsonField("password", this.password);
            if (this.encryptedCredential != null) {
                jsonWriter.writeUntypedField("encryptedCredential", this.encryptedCredential);
            }
            jsonWriter.writeEndObject();
        }
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SybaseLinkedService from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SybaseLinkedService if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SybaseLinkedService.
     */
    @Generated
    public static SybaseLinkedService fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SybaseLinkedService deserializedSybaseLinkedService = new SybaseLinkedService();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("version".equals(fieldName)) {
                    deserializedSybaseLinkedService.setVersion(reader.getString());
                } else if ("connectVia".equals(fieldName)) {
                    deserializedSybaseLinkedService.setConnectVia(IntegrationRuntimeReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedSybaseLinkedService.setDescription(reader.getString());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedSybaseLinkedService.setParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedSybaseLinkedService.setAnnotations(annotations);
                } else if ("type".equals(fieldName)) {
                    deserializedSybaseLinkedService.type = reader.getString();
                } else if ("typeProperties".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("server".equals(fieldName)) {
                            deserializedSybaseLinkedService.server = reader.readUntyped();
                        } else if ("database".equals(fieldName)) {
                            deserializedSybaseLinkedService.database = reader.readUntyped();
                        } else if ("schema".equals(fieldName)) {
                            deserializedSybaseLinkedService.schema = reader.readUntyped();
                        } else if ("authenticationType".equals(fieldName)) {
                            deserializedSybaseLinkedService.authenticationType
                                = SybaseAuthenticationType.fromString(reader.getString());
                        } else if ("username".equals(fieldName)) {
                            deserializedSybaseLinkedService.username = reader.readUntyped();
                        } else if ("password".equals(fieldName)) {
                            deserializedSybaseLinkedService.password = SecretBase.fromJson(reader);
                        } else if ("encryptedCredential".equals(fieldName)) {
                            deserializedSybaseLinkedService.encryptedCredential = reader.readUntyped();
                        } else {
                            reader.skipChildren();
                        }
                    }
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedSybaseLinkedService.setAdditionalProperties(additionalProperties);

            return deserializedSybaseLinkedService;
        });
    }
}
