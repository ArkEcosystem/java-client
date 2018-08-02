package org.arkecosystem.client.api.two

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Wallets extends AbstractAPI
{
    Wallets(Client client) {
        super(client)
    }

    Object all()
    {
        this.client.get('wallets')
    }

    Object show(String id)
    {
        this.client.get("wallets/{id}")
    }

    Object transactions(String id)
    {
        this.client.get("wallets/{id}/transactions")
    }

    Object sentTransactions(String id)
    {
        this.client.get("wallets/{id}/transactions/sent")
    }

    Object receivedTransactions(String id)
    {
        this.client.get("wallets/{id}/transactions/received")
    }

    Object votes(String id)
    {
        this.client.get("wallets/{id}/votes")
    }

    Object search(Map parameters)
    {
        this.client.post('wallets/search', parameters)
    }

    Object top()
    {
        this.client.get('wallets/top')
    }
}
