package org.arkecosystem.client

import org.arkecosystem.client.http.*
import org.arkecosystem.client.api.*

class Connection {
    Client client
    int version

    Connection(String host, int version = 1) {
        this.version = version
        this.client = new Client(host, version)
    }

    AbstractAPI api (String name) {
        String className = name[0].toUpperCase() + name[1..-1]

        Class c = Class.forName("org.arkecosystem.client.api.one.$className")

        c.newInstance this.client
    }
}
