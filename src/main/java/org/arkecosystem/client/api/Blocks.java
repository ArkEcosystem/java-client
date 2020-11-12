package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Blocks {
    private final Client client;

    public Blocks(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("blocks");
    }

    public Map<String, Object> first() throws IOException {
        return this.client.get("blocks/first");
    }

    public Map<String, Object> last() throws IOException {
        return this.client.get("blocks/last");
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("blocks/" + id);
    }

    public Map<String, Object> transactions(String id) throws IOException {
        return this.client.get("blocks/" + id + "/transactions");
    }
}
