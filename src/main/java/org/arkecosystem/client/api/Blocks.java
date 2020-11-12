package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.arkecosystem.client.http.Client;

public class Blocks {
    private final Client client;

    public Blocks(Client client) {
        this.client = client;
    }

    public Map<String, Object> all(Integer page, Integer limit, String id, String height) throws IOException {
        Map<String, Object> params = new LinkedHashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        if (id != null && height != null) {
            throw new IllegalArgumentException("Cannot specify both id and height at the same time");
        }
        if (id != null) {
            params.put("id", id);
        }
        if (height != null) {
            params.put("height", height);
        }
        System.out.println(params);
        return this.client.get("blocks", params);
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("blocks");
    }

    public QueryBuilder allQuery() throws IOException {
        return new QueryBuilder(this.client, "blocks");
    }

    public Map<String, Object> first() throws IOException {
        return this.client.get("blocks/first");
    }

    public Map<String, Object> last() throws IOException {
        return this.client.get("blocks/last");
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("blocks/" + id);
    }

    public Map<String, Object> transactions(String id) throws IOException {
        return this.client.get("blocks/" + id + "/transactions");
    }
}
