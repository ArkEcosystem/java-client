package org.arkecosystem.client

import org.arkecosystem.client.http.*
import org.arkecosystem.client.api.*
import org.arkecosystem.client.api.one.*

class Connection {
    Client client

    Connection(String host, int version = 1) {
        this.client = new Client(host, version)
    }

    AbstractAPI transactions () {
        return new Transactions(this.client)
    }
}
