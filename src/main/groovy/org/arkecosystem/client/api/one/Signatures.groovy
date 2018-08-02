package org.arkecosystem.client.api.one

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Signatures extends AbstractAPI
{
    Signatures(Client client) {
        super(client)
    }

    Object fee()
    {
        this.client.get('signatures/fee')
    }
}
