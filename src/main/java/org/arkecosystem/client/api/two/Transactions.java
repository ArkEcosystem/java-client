package org.arkecosystem.client.api.two;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transactions {
    Client client;

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

    public LinkedTreeMap<String, Object> search(Map<String, Object> parameters) throws IOException {
        return this.client.post("blocks/search", parameters);
    }

    public LinkedTreeMap<String, Object> types() throws IOException {
        return this.client.get("transactions/types");
    }

}
