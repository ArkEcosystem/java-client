package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Locks {
    private final Client client;

    public Locks(Client client) {
        this.client = client;
    }

    public Map<String, Object> all() throws IOException {
        return this.client.get("locks");
    }

    public Map<String, Object> show(String id) throws IOException {
        return this.client.get("locks/" + id);
    }

    public Map<String, Object> searchUnlocked(Map<String, Object> parameters)
            throws IOException {
        return this.client.post("locks/unlocked", parameters);
    }
}
