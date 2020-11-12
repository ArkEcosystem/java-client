package org.arkecosystem.client.api;

import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryBuilder {
    private final Client client;
    private final String endpoint;
    private final Map<String, Object> params;

    public QueryBuilder(Client client, String endpoint) {
        this.client = client;
        this.endpoint = endpoint;
        this.params = new LinkedHashMap<>();
    }

    public QueryBuilder add(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> get() throws IOException {
        return client.get(endpoint, params);
    }
}
