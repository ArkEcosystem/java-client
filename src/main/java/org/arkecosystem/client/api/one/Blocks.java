package org.arkecosystem.client.api.one;

import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Blocks {
    Client client;

    public Blocks(Client client) {
        this.client = client;
    }

    public Object all(Map query) throws IOException {
        return this.client.get("blocks", query);
    }

    public Object all() throws IOException {
        return this.all(new HashMap());
    }

    public Object show(String id) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        return this.client.get("blocks/get", map);
    }

    public Object epoch() throws IOException {
        return this.client.get("blocks/getEpoch");
    }

    public Object fee() throws IOException {
        return this.client.get("blocks/getFee");
    }

    public Object fees() throws IOException {
        return this.client.get("blocks/getFees");
    }

    public Object height() throws IOException {
        return this.client.get("blocks/getHeight");
    }

    public Object milestone() throws IOException {
        return this.client.get("blocks/getMilestone");
    }

    public Object nethash() throws IOException {
        return this.client.get("blocks/getNethash");
    }

    public Object reward() throws IOException {
        return this.client.get("blocks/getReward");
    }

    public Object status() throws IOException {
        return this.client.get("blocks/getStatus");
    }

    public Object supply() throws IOException {
        return this.client.get("blocks/getSupply");
    }

}
