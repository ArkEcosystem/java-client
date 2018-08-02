package org.arkecosystem.client.api.two

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Votes extends AbstractAPI
{
    Votes(Client client) {
        super(client)
    }

    Object all()
    {
        this.client.get('votes')
    }

    Object show(String id)
    {
        this.client.get("votes/{id}")
    }
}
