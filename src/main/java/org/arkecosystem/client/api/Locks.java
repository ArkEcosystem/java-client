package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Locks implements SupportsParams<Locks> {
    private final Client client;

    private final Map<String, Object> params = new LinkedHashMap<>();

    public Locks(Client client) {
        this.client = client;
    }

    @Override
    public Locks param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("locks", params);
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("locks/" + id);
    }

    public Map<String, Object> searchUnlocked() throws IOException {
        return this.client.post("locks/unlocked", params);
    }

    public Map<String, Object> searchUnlocked(Map<String, Object> parameters)
            throws IOException {
        return this.client.post("locks/unlocked", parameters);
    }
}
