package org.arkecosystem.client.api;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Commits {
    private final Client client;

    public Commits(Client client) {
        this.client = client;
    }

    public Map<String, Object> show(int height) throws IOException {
        return this.client.get("commits/" + height);
    }
}
