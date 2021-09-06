package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Blocks implements SupportsParams<Blocks> {
    private final Client client;

    private final Map<String, Object> params = new LinkedHashMap<>();

    public Blocks(Client client) {
        this.client = client;
    }

    @Override
    public Blocks param(String name, Object value) {
        params.put(name, value);
        return this;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("blocks", params);
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
        return this.client.get("blocks/" + id + "/transactions", params);
    }
}
