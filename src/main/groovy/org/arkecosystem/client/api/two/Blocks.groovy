package org.arkecosystem.client.api.two

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Blocks extends AbstractAPI
{
    Blocks(Client client) {
        super(client)
    }

    Object all()
    {
        this.client.get('blocks')
    }

    Object show(String id)
    {
        this.client.get("blocks/{id}")
    }

    Object transactions(String id)
    {
        this.client.get("blocks/{id}/transactions")
    }

    Object search(Map parameters)
    {
        this.client.post('blocks/search', parameters)
    }
}
