package org.arkecosystem.client.api.one

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Delegates extends AbstractAPI
{
    Delegates(Client client) {
        super(client)
    }

    Object all(Map query = [:])
    {
        this.client.get('delegates', query)
    }

    Object show(Map id)
    {
        this.client.get('delegates/get', id)
    }

    Object count()
    {
        this.client.get('delegates/count')
    }

    Object fee()
    {
        this.client.get('delegates/fee')
    }

    Object forgedByAccount(String generatorPublicKey)
    {
        this.client.get('delegates/forging/getForgedByAccount', [generatorPublicKey: generatorPublicKey])
    }

    Object search(String query)
    {
        this.client.get('delegates/search', [q: query])
    }

    Object voters(String publicKey)
    {
        this.client.get('delegates/voters', [publicKey: publicKey])
    }

    Object nextForgers()
    {
        this.client.get('delegates/getNextForgers')
    }
}
