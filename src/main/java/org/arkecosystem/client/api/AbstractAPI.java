package org.arkecosystem.client.api;

import org.arkecosystem.client.http.Client;

public abstract class AbstractAPI {

    protected Client client;

    public AbstractAPI(Client client) {
        this.client = client;
    }
}
