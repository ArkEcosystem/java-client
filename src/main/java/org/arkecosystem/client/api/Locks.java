package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Locks {
    private Client client;

    public Locks(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> all() throws IOException {
        return this.client.get("locks");
    }

    public LinkedTreeMap<String, Object> show(String id) throws IOException {
        return this.client.get("locks/" + id);
    }

    public LinkedTreeMap<String, Object> search(Map<String, Object> parameters) throws IOException {
        return this.client.post("locks/search", parameters);
    }

    public LinkedTreeMap<String, Object> searchUnlocked(Map<String, Object> parameters)
            throws IOException {
        return this.client.post("locks/unlocked", parameters);
    }
}
