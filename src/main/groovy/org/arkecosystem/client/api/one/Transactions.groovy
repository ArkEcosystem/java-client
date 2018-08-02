package org.arkecosystem.client.api.one

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Transactions extends AbstractAPI
{
    Transactions(Client client) {
        super(client)
    }

    Object all(Map query = [:])
    {
        this.client.get('transactions', query)
    }

    Object show(String id)
    {
        this.client.get('transactions/get', [id: id])
    }

    Object allUnconfirmed(Map query = [:])
    {
        this.client.get('transactions/unconfirmed', query)
    }

    Object showUnconfirmed(String id)
    {
        this.client.get('transactions/unconfirmed/get', [id: id])
    }
}
