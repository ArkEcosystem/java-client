package org.arkecosystem.client.api;

import org.arkecosystem.client.http.Client;

public abstract class AbstractAPI {

    public AbstractAPI(Client client) {
        this.client = client;
    }

    protected Client client;
}
