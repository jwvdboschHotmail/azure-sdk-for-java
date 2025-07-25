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
 * Greenplum Database linked service.
 */
@Fluent
public class GreenplumLinkedService extends LinkedService {
    /*
     * Type of linked service.
     */
    @Generated
    private String type = "Greenplum";

    /*
     * An ODBC connection string. Type: string, SecureString or AzureKeyVaultSecretReference.
     */
    @Generated
    private Object connectionString;

    /*
     * The Azure key vault secret reference of password in connection string.
     */
    @Generated
    private AzureKeyVaultSecretReference pwd;

    /*
     * The encrypted credential used for authentication. Credentials are encrypted using the integration runtime
     * credential manager. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object encryptedCredential;

    /*
     * The authentication type to use. Type: string. Only used for V2.
     */
    @Generated
    private GreenplumAuthenticationType authenticationType;

    /*
     * Host name for connection. Type: string. Only used for V2.
     */
    @Generated
    private Object host;

    /*
     * The port for the connection. Type: integer. Only used for V2.
     */
    @Generated
    private Object port;

    /*
     * Username for authentication. Type: string. Only used for V2.
     */
    @Generated
    private Object username;

    /*
     * Database name for connection. Type: string. Only used for V2.
     */
    @Generated
    private Object database;

    /*
     * SSL mode for connection. Type: integer. 0: disable, 1:allow, 2: prefer, 3: require, 4: verify-ca, 5: verify-full.
     * Type: integer. Only used for V2.
     */
    @Generated
    private Object sslMode;

    /*
     * The time to wait (in seconds) while trying to establish a connection before terminating the attempt and
     * generating an error. Type: integer. Only used for V2.
     */
    @Generated
    private Object connectionTimeout;

    /*
     * The time to wait (in seconds) while trying to execute a command before terminating the attempt and generating an
     * error. Set to zero for infinity. Type: integer. Only used for V2.
     */
    @Generated
    private Object commandTimeout;

    /*
     * The Azure key vault secret reference of password in connection string. Type: string. Only used for V2.
     */
    @Generated
    private SecretBase password;

    /**
     * Creates an instance of GreenplumLinkedService class.
     */
    @Generated
    public GreenplumLinkedService() {
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
     * Get the connectionString property: An ODBC connection string. Type: string, SecureString or
     * AzureKeyVaultSecretReference.
     * 
     * @return the connectionString value.
     */
    @Generated
    public Object getConnectionString() {
        return this.connectionString;
    }

    /**
     * Set the connectionString property: An ODBC connection string. Type: string, SecureString or
     * AzureKeyVaultSecretReference.
     * 
     * @param connectionString the connectionString value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setConnectionString(Object connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    /**
     * Get the pwd property: The Azure key vault secret reference of password in connection string.
     * 
     * @return the pwd value.
     */
    @Generated
    public AzureKeyVaultSecretReference getPwd() {
        return this.pwd;
    }

    /**
     * Set the pwd property: The Azure key vault secret reference of password in connection string.
     * 
     * @param pwd the pwd value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setPwd(AzureKeyVaultSecretReference pwd) {
        this.pwd = pwd;
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
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setEncryptedCredential(Object encryptedCredential) {
        this.encryptedCredential = encryptedCredential;
        return this;
    }

    /**
     * Get the authenticationType property: The authentication type to use. Type: string. Only used for V2.
     * 
     * @return the authenticationType value.
     */
    @Generated
    public GreenplumAuthenticationType getAuthenticationType() {
        return this.authenticationType;
    }

    /**
     * Set the authenticationType property: The authentication type to use. Type: string. Only used for V2.
     * 
     * @param authenticationType the authenticationType value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setAuthenticationType(GreenplumAuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
        return this;
    }

    /**
     * Get the host property: Host name for connection. Type: string. Only used for V2.
     * 
     * @return the host value.
     */
    @Generated
    public Object getHost() {
        return this.host;
    }

    /**
     * Set the host property: Host name for connection. Type: string. Only used for V2.
     * 
     * @param host the host value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setHost(Object host) {
        this.host = host;
        return this;
    }

    /**
     * Get the port property: The port for the connection. Type: integer. Only used for V2.
     * 
     * @return the port value.
     */
    @Generated
    public Object getPort() {
        return this.port;
    }

    /**
     * Set the port property: The port for the connection. Type: integer. Only used for V2.
     * 
     * @param port the port value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setPort(Object port) {
        this.port = port;
        return this;
    }

    /**
     * Get the username property: Username for authentication. Type: string. Only used for V2.
     * 
     * @return the username value.
     */
    @Generated
    public Object getUsername() {
        return this.username;
    }

    /**
     * Set the username property: Username for authentication. Type: string. Only used for V2.
     * 
     * @param username the username value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setUsername(Object username) {
        this.username = username;
        return this;
    }

    /**
     * Get the database property: Database name for connection. Type: string. Only used for V2.
     * 
     * @return the database value.
     */
    @Generated
    public Object getDatabase() {
        return this.database;
    }

    /**
     * Set the database property: Database name for connection. Type: string. Only used for V2.
     * 
     * @param database the database value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setDatabase(Object database) {
        this.database = database;
        return this;
    }

    /**
     * Get the sslMode property: SSL mode for connection. Type: integer. 0: disable, 1:allow, 2: prefer, 3: require, 4:
     * verify-ca, 5: verify-full. Type: integer. Only used for V2.
     * 
     * @return the sslMode value.
     */
    @Generated
    public Object getSslMode() {
        return this.sslMode;
    }

    /**
     * Set the sslMode property: SSL mode for connection. Type: integer. 0: disable, 1:allow, 2: prefer, 3: require, 4:
     * verify-ca, 5: verify-full. Type: integer. Only used for V2.
     * 
     * @param sslMode the sslMode value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setSslMode(Object sslMode) {
        this.sslMode = sslMode;
        return this;
    }

    /**
     * Get the connectionTimeout property: The time to wait (in seconds) while trying to establish a connection before
     * terminating the attempt and generating an error. Type: integer. Only used for V2.
     * 
     * @return the connectionTimeout value.
     */
    @Generated
    public Object getConnectionTimeout() {
        return this.connectionTimeout;
    }

    /**
     * Set the connectionTimeout property: The time to wait (in seconds) while trying to establish a connection before
     * terminating the attempt and generating an error. Type: integer. Only used for V2.
     * 
     * @param connectionTimeout the connectionTimeout value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setConnectionTimeout(Object connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    /**
     * Get the commandTimeout property: The time to wait (in seconds) while trying to execute a command before
     * terminating the attempt and generating an error. Set to zero for infinity. Type: integer. Only used for V2.
     * 
     * @return the commandTimeout value.
     */
    @Generated
    public Object getCommandTimeout() {
        return this.commandTimeout;
    }

    /**
     * Set the commandTimeout property: The time to wait (in seconds) while trying to execute a command before
     * terminating the attempt and generating an error. Set to zero for infinity. Type: integer. Only used for V2.
     * 
     * @param commandTimeout the commandTimeout value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setCommandTimeout(Object commandTimeout) {
        this.commandTimeout = commandTimeout;
        return this;
    }

    /**
     * Get the password property: The Azure key vault secret reference of password in connection string. Type: string.
     * Only used for V2.
     * 
     * @return the password value.
     */
    @Generated
    public SecretBase getPassword() {
        return this.password;
    }

    /**
     * Set the password property: The Azure key vault secret reference of password in connection string. Type: string.
     * Only used for V2.
     * 
     * @param password the password value to set.
     * @return the GreenplumLinkedService object itself.
     */
    @Generated
    public GreenplumLinkedService setPassword(SecretBase password) {
        this.password = password;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GreenplumLinkedService setVersion(String version) {
        super.setVersion(version);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GreenplumLinkedService setConnectVia(IntegrationRuntimeReference connectVia) {
        super.setConnectVia(connectVia);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GreenplumLinkedService setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GreenplumLinkedService setParameters(Map<String, ParameterSpecification> parameters) {
        super.setParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GreenplumLinkedService setAnnotations(List<Object> annotations) {
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
        if (connectionString != null
            || pwd != null
            || encryptedCredential != null
            || authenticationType != null
            || host != null
            || port != null
            || username != null
            || database != null
            || sslMode != null
            || connectionTimeout != null
            || commandTimeout != null
            || password != null) {
            jsonWriter.writeStartObject("typeProperties");
            if (this.connectionString != null) {
                jsonWriter.writeUntypedField("connectionString", this.connectionString);
            }
            jsonWriter.writeJsonField("pwd", this.pwd);
            if (this.encryptedCredential != null) {
                jsonWriter.writeUntypedField("encryptedCredential", this.encryptedCredential);
            }
            jsonWriter.writeStringField("authenticationType",
                this.authenticationType == null ? null : this.authenticationType.toString());
            if (this.host != null) {
                jsonWriter.writeUntypedField("host", this.host);
            }
            if (this.port != null) {
                jsonWriter.writeUntypedField("port", this.port);
            }
            if (this.username != null) {
                jsonWriter.writeUntypedField("username", this.username);
            }
            if (this.database != null) {
                jsonWriter.writeUntypedField("database", this.database);
            }
            if (this.sslMode != null) {
                jsonWriter.writeUntypedField("sslMode", this.sslMode);
            }
            if (this.connectionTimeout != null) {
                jsonWriter.writeUntypedField("connectionTimeout", this.connectionTimeout);
            }
            if (this.commandTimeout != null) {
                jsonWriter.writeUntypedField("commandTimeout", this.commandTimeout);
            }
            jsonWriter.writeJsonField("password", this.password);
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
     * Reads an instance of GreenplumLinkedService from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GreenplumLinkedService if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the GreenplumLinkedService.
     */
    @Generated
    public static GreenplumLinkedService fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GreenplumLinkedService deserializedGreenplumLinkedService = new GreenplumLinkedService();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("version".equals(fieldName)) {
                    deserializedGreenplumLinkedService.setVersion(reader.getString());
                } else if ("connectVia".equals(fieldName)) {
                    deserializedGreenplumLinkedService.setConnectVia(IntegrationRuntimeReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedGreenplumLinkedService.setDescription(reader.getString());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedGreenplumLinkedService.setParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedGreenplumLinkedService.setAnnotations(annotations);
                } else if ("type".equals(fieldName)) {
                    deserializedGreenplumLinkedService.type = reader.getString();
                } else if ("typeProperties".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("connectionString".equals(fieldName)) {
                            deserializedGreenplumLinkedService.connectionString = reader.readUntyped();
                        } else if ("pwd".equals(fieldName)) {
                            deserializedGreenplumLinkedService.pwd = AzureKeyVaultSecretReference.fromJson(reader);
                        } else if ("encryptedCredential".equals(fieldName)) {
                            deserializedGreenplumLinkedService.encryptedCredential = reader.readUntyped();
                        } else if ("authenticationType".equals(fieldName)) {
                            deserializedGreenplumLinkedService.authenticationType
                                = GreenplumAuthenticationType.fromString(reader.getString());
                        } else if ("host".equals(fieldName)) {
                            deserializedGreenplumLinkedService.host = reader.readUntyped();
                        } else if ("port".equals(fieldName)) {
                            deserializedGreenplumLinkedService.port = reader.readUntyped();
                        } else if ("username".equals(fieldName)) {
                            deserializedGreenplumLinkedService.username = reader.readUntyped();
                        } else if ("database".equals(fieldName)) {
                            deserializedGreenplumLinkedService.database = reader.readUntyped();
                        } else if ("sslMode".equals(fieldName)) {
                            deserializedGreenplumLinkedService.sslMode = reader.readUntyped();
                        } else if ("connectionTimeout".equals(fieldName)) {
                            deserializedGreenplumLinkedService.connectionTimeout = reader.readUntyped();
                        } else if ("commandTimeout".equals(fieldName)) {
                            deserializedGreenplumLinkedService.commandTimeout = reader.readUntyped();
                        } else if ("password".equals(fieldName)) {
                            deserializedGreenplumLinkedService.password = SecretBase.fromJson(reader);
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
            deserializedGreenplumLinkedService.setAdditionalProperties(additionalProperties);

            return deserializedGreenplumLinkedService;
        });
    }
}
