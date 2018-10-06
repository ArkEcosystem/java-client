package org.arkecosystem.client.api.one;

import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Peers {
    Client client;

    public Peers(Client client) {
        this.client = client;
    }

    public Object all(Map query) throws IOException {
        return this.client.get("peers", query);
    }

    public Object all() throws IOException {
        return this.all(new HashMap());
    }

    public Object show(String ip, int port) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ip", ip);
        map.put("port", port);
        return this.client.get("peers/get", map);
    }

    public Object version() throws IOException {
        return this.client.get("peers/version");
    }

}
