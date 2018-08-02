package org.arkecosystem.client.api.one

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Peers extends AbstractAPI
{
    Peers(Client client) {
        super(client)
    }

    Object all(Map query = [:])
    {
        this.client.get('peers', query)
    }

    Object show(String ip, int port)
    {
        this.client.get('peers/get', [ip: ip, port: port])
    }

    Object version()
    {
        this.client.get('peers/version')
    }
}
