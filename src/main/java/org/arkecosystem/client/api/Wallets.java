package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Wallets {
    Client client;

    public Wallets(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> all() throws IOException {
        return this.client.get("wallets");
    }

    public LinkedTreeMap<String, Object> show(String id) throws IOException {
        return this.client.get("wallets/" + id);
    }

    public LinkedTreeMap<String, Object> transactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions");
    }

    public LinkedTreeMap<String, Object> sentTransactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions/sent");
    }

    public LinkedTreeMap<String, Object> receivedTransactions(String id) throws IOException {
        return this.client.get("wallets/" + id + "/transactions/received");
    }

    public LinkedTreeMap<String, Object> votes(String id) throws IOException {
        return this.client.get("wallets/" + id + "/votes");
    }

    public LinkedTreeMap<String, Object> search(Map<String, Object> parameters) throws IOException {
        return this.client.post("wallets/search", parameters);
    }

    public LinkedTreeMap<String, Object> top() throws IOException {
        return this.client.get("wallets/top");
    }
}
