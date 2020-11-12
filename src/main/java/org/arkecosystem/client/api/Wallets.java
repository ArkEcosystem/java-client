package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Wallets implements SupportsParams<Wallets> {
    private final Client client;

    private final Map<String, Object> params = new LinkedHashMap<>();

    public Wallets(Client client) {
        this.client = client;
    }

    @Override
    public Wallets param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("wallets", params);
    }

    public Map<String, Object> top() throws IOException {
        return this.client.get("wallets/top", params);
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("wallets/" + id);
    }

    public Map<String, Object> transactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions", params);
    }

    public Map<String, Object> sentTransactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions/sent", params);
    }

    public Map<String, Object> receivedTransactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions/received", params);
    }

    public Map<String, Object> votes(String id) throws IOException {
        return this.client.get("wallets/" + id + "/votes", params);
    }

    public Map<String, Object> locks(String id) throws IOException {
        return this.client.get("wallets/" + id + "/locks");
    }
}
