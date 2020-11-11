package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.arkecosystem.client.http.Client;

public class Transactions {
    private Client client;

    public Transactions(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> all() throws IOException {
        return this.client.get("transactions");
    }

    public LinkedTreeMap<String, Object> create(List<HashMap> transactions) throws IOException {
        HashMap<String, List<HashMap>> params = new HashMap<>();
        params.put("transactions", transactions);
        return this.client.post("transactions", params);
    }

    public LinkedTreeMap<String, Object> show(String id) throws IOException {
        return this.client.get("transactions/" + id);
    }

    public LinkedTreeMap<String, Object> allUnconfirmed() throws IOException {
        return this.client.get("transactions/unconfirmed");
    }

    public LinkedTreeMap<String, Object> showUnconfirmed(String id) throws IOException {
        return this.client.get("transactions/unconfirmed/" + id);
    }

    public LinkedTreeMap<String, Object> types() throws IOException {
        return this.client.get("transactions/types");
    }

    public LinkedTreeMap<String, Object> schemas() throws IOException {
        return this.client.get("transactions/schemas");
    }

    public LinkedTreeMap<String, Object> fees() throws IOException {
        return this.client.get("transactions/fees");
    }
}
