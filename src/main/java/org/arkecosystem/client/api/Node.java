package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.HashMap;

public class Node {
    private Client client;

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

    public LinkedTreeMap<String, Object> crypto() throws IOException {
        return this.client.get("node/configuration/crypto");
    }

    public LinkedTreeMap<String, Object> fees() throws IOException {
        return this.client.get("node/fees");
    }

    public LinkedTreeMap<String, Object> debug() throws IOException {
        return this.client.get("node/debug");
    }

}
