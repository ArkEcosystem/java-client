package org.arkecosystem.client.api.two

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Peers extends AbstractAPI
{
    Peers(Client client) {
        super(client)
    }

    Object all()
    {
        this.client.get('peers')
    }

    Object show(String ip)
    {
        this.client.get("peers/{ip}")
    }
}
