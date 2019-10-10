package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.HashMap;

public class Node {
    Client client;

    public Node(Client client) {
        this.client = client;
    }

  public LinkedTreeMap<String, Object> fees(Integer... days) throws IOException {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("days", days.length > 0 ? days[0] : null);
        return this.client.get("node/fees", parameters);
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
}
