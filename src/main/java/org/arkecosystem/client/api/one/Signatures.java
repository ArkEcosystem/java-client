package org.arkecosystem.client.api.one;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.http.Client;

import java.io.IOException;

public class Signatures {
    Client client;

    public Signatures(Client client) {
        this.client = client;
    }

    public LinkedTreeMap<String, Object> fee() throws IOException {
        return this.client.get("signatures/fee");
    }

}
