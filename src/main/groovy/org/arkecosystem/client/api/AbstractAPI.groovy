package org.arkecosystem.client.api

import org.arkecosystem.client.http.*

abstract class AbstractAPI {
    Client client

    AbstractAPI(Client client) {
        this.client = client
    }
}
