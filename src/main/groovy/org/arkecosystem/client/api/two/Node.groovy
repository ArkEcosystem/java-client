package org.arkecosystem.client.api.two

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Node extends AbstractAPI
{
    Node(Client client) {
        super(client)
    }

    Object status()
    {
        this.client.get('node/status')
    }

    Object syncing()
    {
        this.client.get('node/syncing')
    }

    Object configuration()
    {
        this.client.get('node/configuration')
    }
}
