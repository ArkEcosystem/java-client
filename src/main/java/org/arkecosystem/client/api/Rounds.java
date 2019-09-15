package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.http.Client;

import java.io.IOException;

public class Rounds {
    Client client;

    public Rounds(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> delegates(int id) throws IOException {
        return this.client.get("rounds/" + id + "/delegates");
    }

}
