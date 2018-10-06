package org.arkecosystem.client.api.one;

import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Transactions {
    Client client;

    public Transactions(Client client) {
        this.client = client;
    }

    public Object all(Map query) throws IOException {
        return this.client.get("transactions", query);
    }

    public Object all() throws IOException {
        return this.all(new HashMap());
    }

    public Object show(String id) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        return this.client.get("transactions/get", map);
    }

    public Object allUnconfirmed(Map query) throws IOException {
        return this.client.get("transactions/unconfirmed", query);
    }

    public Object allUnconfirmed() throws IOException {
        return this.allUnconfirmed(new HashMap());
    }

    public Object showUnconfirmed(String id) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        return this.client.get("transactions/unconfirmed/get", map);
    }

}
