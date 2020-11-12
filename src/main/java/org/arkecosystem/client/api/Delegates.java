package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Delegates implements SupportsParams<Delegates> {
    private final Client client;

    private final Map<String, Object> params = new LinkedHashMap<>();

    public Delegates(Client client) {
        this.client = client;
    }

    @Override
    public Delegates param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("delegates", params);
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("delegates/" + id);
    }

    public Map<String, Object> blocks(String id) throws IOException {
        return this.client.get("delegates/" + id + "/blocks", params);
    }

    public Map<String, Object> voters(String id) throws IOException {
        return this.client.get("delegates/" + id + "/voters", params);
    }

    public Map<String, Object> search() throws IOException {
        return this.client.post("delegates/search", params);
    }

    public Map<String, Object> search(Map<String, Object> parameters) throws IOException {
        return this.client.post("delegates/search", parameters);
    }
}
