package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Wallets {
    private final Client client;

    public Wallets(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("wallets");
    }

    public Map<String, Object> top() throws IOException {
        return this.client.get("wallets/top");
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("wallets/" + id);
    }

    public Map<String, Object> transactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions");
    }

    public Map<String, Object> sentTransactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions/sent");
    }

    public Map<String, Object> receivedTransactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions/received");
    }

    public Map<String, Object> votes(String id) throws IOException {
        return this.client.get("wallets/" + id + "/votes");
    }

    public Map<String, Object> locks(String id) throws IOException {
        return this.client.get("wallets/" + id + "/locks");
    }
}
