package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Rounds {
    private final Client client;

    public Rounds(Client client) {
        this.client = client;
    }

    public Map<String, Object> delegates(int id) throws IOException {
        return this.client.get("rounds/" + id + "/delegates");
    }
}
