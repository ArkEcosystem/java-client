package org.arkecosystem.client.api.two

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Delegates extends AbstractAPI
{
    Delegates(Client client) {
        super(client)
    }

    Object all()
    {
        this.client.get('delegates')
    }

    Object show(String id)
    {
        this.client.get("delegates/{id}")
    }

    Object blocks(String id)
    {
        this.client.get("delegates/{id}/blocks")
    }

    Object voters(String id)
    {
        this.client.get("delegates/{id}/voters")
    }
}
