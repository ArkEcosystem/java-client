package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Blockchain {

    private final Client client;

    public Blockchain(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("blockchain");
    }
}
