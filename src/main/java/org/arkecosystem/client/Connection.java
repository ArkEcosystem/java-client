package org.arkecosystem.client;

import org.arkecosystem.client.api.Api;
import org.arkecosystem.client.http.Client;

import java.util.Map;

public class Connection {
    private Api api;
    private Client client;
    private int version;

    public Connection(Map<String, Object> config) {
        this.version = ((int) (config.get("API-Version")));
        this.client = new Client(config.get("host").toString(), Integer.toString(this.version));
        this.api = new Api(this.client);
    }

    public Api api() {
        return this.api;
    }
}
