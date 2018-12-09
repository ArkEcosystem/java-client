package org.arkecosystem.client;

import org.arkecosystem.client.api.AbstractAPI;
import org.arkecosystem.client.api.two.Two;
import org.arkecosystem.client.http.Client;

import java.util.Map;

public class Connection<T extends AbstractAPI> {

    private Client client;
    private int version;

    private T api;

    public Connection(Map<String, Object> config) {
        this.version = ((int) (config.get("version")));
        this.client = new Client(config.get("host").toString(), (int) config.get("version"));

        this.api = (T) new Two(this.client));
    }

    public T api() {
        return this.api;
    }

}
