package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Entities implements SupportsParams<Entities> {
    private final Client client;

    private final Map<String, Object> params = new LinkedHashMap<>();

    public Entities(Client client) {
        this.client = client;
    }

    @Override
    public Entities param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("entities", params);
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("entities/" + id);
    }
}
