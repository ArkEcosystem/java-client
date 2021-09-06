package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Peers implements SupportsParams<Peers> {
    private final Client client;

    private final Map<String, Object> params = new LinkedHashMap<>();

    public Peers(Client client) {
        this.client = client;
    }

    @Override
    public Peers param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("peers", params);
    }

    public Map<String, Object> show(String ip) throws IOException {
        return this.client.get("peers/" + ip);
    }
}
