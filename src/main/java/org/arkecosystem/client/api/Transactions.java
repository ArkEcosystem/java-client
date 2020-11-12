package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Transactions {
    private final Client client;

    public Transactions(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("transactions");
    }

    public Map<String, Object> create(List<Map<String, ?>> transactions) throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("transactions", transactions);
        return this.client.post("transactions", params);
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("transactions/" + id);
    }

    public Map<String, Object> allUnconfirmed() throws IOException {
        return this.client.get("transactions/unconfirmed");
    }

    public Map<String, Object> showUnconfirmed(String id) throws IOException {
        return this.client.get("transactions/unconfirmed/" + id);
    }

    public Map<String, Object> types() throws IOException {
        return this.client.get("transactions/types");
    }

    public Map<String, Object> schemas() throws IOException {
        return this.client.get("transactions/schemas");
    }

    public Map<String, Object> fees() throws IOException {
        return this.client.get("transactions/fees");
    }
}
