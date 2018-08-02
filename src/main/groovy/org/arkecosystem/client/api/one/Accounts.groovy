package org.arkecosystem.client.api.one

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Accounts extends AbstractAPI
{
    Accounts(Client client) {
        super(client)
    }

    Object all(Map query = [:])
    {
        this.client.get('accounts/getAllAccounts', query)
    }

    Object show(String address)
    {
        this.client.get('accounts', [address: address])
    }

    Object count()
    {
        this.client.get('accounts/count')
    }

    Object delegates(String address)
    {
        this.client.get('accounts/delegates', [address: address])
    }

    Object fee()
    {
        this.client.get('accounts/delegates/fee')
    }

    Object balance(String address)
    {
        this.client.get('accounts/getBalance', [address: address])
    }

    Object publicKey(String address)
    {
        this.client.get('accounts/getPublicKey', [address: address])
    }

    Object top(Map query = [:])
    {
        this.client.get('accounts/top', query)
    }
}
