package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Peers {
    private final Client client;

    public Peers(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("peers");
    }

    public Map<String, Object> show(String ip) throws IOException {
        return this.client.get("peers/" + ip);
    }
}
