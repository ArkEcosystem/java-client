package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Delegates {
    private Client client;

    public Delegates(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> all() throws IOException {
        return this.client.get("delegates");
    }

    public LinkedTreeMap<String, Object> show(String id) throws IOException {
        return this.client.get("delegates/" + id);
    }

    public LinkedTreeMap<String, Object> blocks(String id) throws IOException {
        return this.client.get("delegates/" + id + "/blocks");
    }

    public LinkedTreeMap<String, Object> voters(String id) throws IOException {
        return this.client.get("delegates/" + id + "/voters");
    }

    public LinkedTreeMap<String, Object> search(Map<String, Object> parameters) throws IOException {
        return this.client.post("delegates/search", parameters);
    }
}
