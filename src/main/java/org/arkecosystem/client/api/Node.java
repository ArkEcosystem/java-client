package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Node {
    private final Client client;

    public Node(Client client) {
        this.client = client;
    }

    public Map<String, Object> status() throws IOException {
        return this.client.get("node/status");
    }

    public Map<String, Object> syncing() throws IOException {
        return this.client.get("node/syncing");
    }

    public Map<String, Object> configuration() throws IOException {
        return this.client.get("node/configuration");
    }

    public Map<String, Object> crypto() throws IOException {
        return this.client.get("node/configuration/crypto");
    }

    public Map<String, Object> fees(int days) throws IOException {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("days", days);
        return this.client.get("node/fees", parameters);
    }

    public Map<String, Object> fees() throws IOException {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("days", null);
        return this.client.get("node/fees", parameters);
    }

    public Map<String, Object> debug() throws IOException {
        return this.client.get("node/debug");
    }
}
