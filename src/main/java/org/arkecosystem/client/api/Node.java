package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import org.arkecosystem.client.http.Client;

public class Node {
    Client client;

    public Node(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> status() throws IOException {
        return this.client.get("node/status");
    }

    public LinkedTreeMap<String, Object> syncing() throws IOException {
        return this.client.get("node/syncing");
    }

    public LinkedTreeMap<String, Object> configuration() throws IOException {
        return this.client.get("node/configuration");
    }
}
