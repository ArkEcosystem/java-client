package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import org.arkecosystem.client.http.Client;

public class Votes {
    private Client client;

    public Votes(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> all() throws IOException {
        return this.client.get("votes");
    }

    public LinkedTreeMap<String, Object> show(String id) throws IOException {
        return this.client.get("votes/" + id);
    }
}
