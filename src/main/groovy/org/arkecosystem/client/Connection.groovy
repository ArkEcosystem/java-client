package org.arkecosystem.client

import org.arkecosystem.client.http.*
import org.arkecosystem.client.api.*

class Connection {
    Client client
    int version

    Connection(Map config) {
        this.version = config.get('version')
        this.client = new Client(config.get('host'), config.get('version'))
    }

    AbstractAPI api (String name) {
        String className = name[0].toUpperCase() + name[1..-1]
        String version = (this.version == 1) ? 'one' : 'two'

        Class
            .forName("org.arkecosystem.client.api.$version.$className")
            .newInstance this.client
    }
}
