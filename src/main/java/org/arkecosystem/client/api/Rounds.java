package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Rounds {
    private final Client client;
    private final Map<String, Object> params = new LinkedHashMap<>();

    public Rounds(Client client) {
        this.client = client;
    }

    public Rounds param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> delegates(int id) throws IOException {
        return this.client.get("rounds/" + id + "/delegates");
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("rounds", params);
    }

    public Map<String, Object> show(int roundId) throws IOException {
        return this.client.get("rounds/" + roundId);
    }
}
