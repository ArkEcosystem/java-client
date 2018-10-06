package org.arkecosystem.client.api.one;

import org.arkecosystem.client.http.Client;

import java.io.IOException;

public class Loader {
    Client client;

    public Loader(Client client) {
        this.client = client;
    }

    public Object status() throws IOException {
        return this.client.get("loader/status");
    }

    public Object sync() throws IOException {
        return this.client.get("loader/status/sync");
    }

    public Object autoconfigure() throws IOException {
        return this.client.get("loader/autoconfigure");
    }

}
