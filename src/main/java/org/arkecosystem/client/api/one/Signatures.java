package org.arkecosystem.client.api.one;

import org.arkecosystem.client.http.Client;

import java.io.IOException;

public class Signatures {
    Client client;

    public Signatures(Client client) {
        this.client = client;
    }

    public Object fee() throws IOException {
        return this.client.get("signatures/fee");
    }

}
