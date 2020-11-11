package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Delegates {
    private final Client client;

    public Delegates(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("delegates");
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("delegates/" + id);
    }

    public Map<String, Object> blocks(String id) throws IOException {
        return this.client.get("delegates/" + id + "/blocks");
    }

    public Map<String, Object> voters(String id) throws IOException {
        return this.client.get("delegates/" + id + "/voters");
    }

    public Map<String, Object> search(Map<String, Object> parameters) throws IOException {
        return this.client.post("delegates/search", parameters);
    }
}
