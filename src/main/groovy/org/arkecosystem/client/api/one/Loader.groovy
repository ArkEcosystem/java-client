package org.arkecosystem.client.api.one

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Loader extends AbstractAPI
{
    Loader(Client client) {
        super(client)
    }

    Object status()
    {
        this.client.get('loader/status')
    }

    Object sync()
    {
        this.client.get('loader/status/sync')
    }

    Object autoconfigure()
    {
        this.client.get('loader/autoconfigure')
    }
}
