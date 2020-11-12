package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Votes {
    private final Client client;

    public Votes(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("votes");
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("votes/" + id);
    }
}
