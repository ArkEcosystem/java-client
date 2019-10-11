package org.arkecosystem.client;

import java.util.Map;
import org.arkecosystem.client.api.Api;
import org.arkecosystem.client.http.Client;

public class Connection {
    private Api api;
    private Client client;

    public Connection(Map<String, Object> config) {
        this.client = new Client(config.get("host").toString());
        this.api = new Api(this.client);
    }

    public Api api() {
        return this.api;
    }
}
