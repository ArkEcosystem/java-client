package org.arkecosystem.client.api.two;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.http.Client;

import java.io.IOException;

public class Votes {
    Client client;

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
