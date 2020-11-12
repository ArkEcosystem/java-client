package org.arkecosystem.client.api;

import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.Map;

public class Entities {
    private final Client client;

    public Entities(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("entities");
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("entities/" + id);
    }

}
