package org.arkecosystem.client.api.one;

import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Delegates {
    Client client;

    public Delegates(Client client) {
        this.client = client;
    }

    public Object all(Map query) throws IOException {
        return this.client.get("delegates", query);
    }

    public Object all() throws IOException {
        return this.all(new HashMap());
    }

    public Object show(Map id) throws IOException {
        return this.client.get("delegates/get", id);
    }

    public Object count() throws IOException {
        return this.client.get("delegates/count");
    }

    public Object fee() throws IOException {
        return this.client.get("delegates/fee");
    }

    public Object forgedByAccount(String generatorPublicKey) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("generatorPublicKey", generatorPublicKey);
        return this.client.get("delegates/forging/getForgedByAccount", map);
    }

    public Object search(String query) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("q", query);
        return this.client.get("delegates/search", map);
    }

    public Object voters(String publicKey) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("publicKey", publicKey);
        return this.client.get("delegates/voters", map);
    }

    public Object nextForgers() throws IOException {
        return this.client.get("delegates/getNextForgers");
    }

}
