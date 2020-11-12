package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Votes implements SupportsParams<Votes> {
    private final Client client;

    private final Map<String, Object> params = new LinkedHashMap<>();

    public Votes(Client client) {
        this.client = client;
    }

    @Override
    public Votes param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("votes", params);
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("votes/" + id);
    }
}
