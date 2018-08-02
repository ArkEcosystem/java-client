package org.arkecosystem.client.api.two

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Transactions extends AbstractAPI
{
    Transactions(Client client) {
        super(client)
    }

    Object all()
    {
        this.client.get('transactions')
    }

    Object create(Map transactions)
    {
        this.client.post('transactions', transactions)
    }

    Object show(String id)
    {
        this.client.get("transactions/{id}")
    }

    Object allUnconfirmed()
    {
        this.client.get('transactions/unconfirmed')
    }

    Object showUnconfirmed(String id)
    {
        this.client.get("transactions/unconfirmed/{id}")
    }

    Object search(Map parameters)
    {
        this.client.post('transactions/search', parameters)
    }

    Object types()
    {
        this.client.get('transactions/types')
    }
}
