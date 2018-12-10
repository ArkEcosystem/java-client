package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.http.Client;

import java.io.IOException;

public class Peers {
    Client client;

    public Peers(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> all() throws IOException {
        return this.client.get("peers");
    }

    public LinkedTreeMap<String, Object> show(String ip) throws IOException {
        return this.client.get("peers/" + ip);
    }

}
