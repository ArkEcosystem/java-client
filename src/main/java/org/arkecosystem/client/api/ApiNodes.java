package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class ApiNodes implements SupportsParams<ApiNodes> {
    private final Client client;

    private final Map<String, Object> params = new LinkedHashMap<>();

    public ApiNodes(Client client) {
        this.client = client;
    }

    @Override
    public ApiNodes param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("api-nodes", params);
    }
}
