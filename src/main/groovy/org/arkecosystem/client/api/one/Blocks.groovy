package org.arkecosystem.client.api.one

import org.arkecosystem.client.api.AbstractAPI
import org.arkecosystem.client.http.Client

class Blocks extends AbstractAPI
{
    Blocks(Client client) {
        super(client)
    }

    Object all(Map query = [:])
    {
        this.client.get('blocks', query)
    }

    Object show(String id)
    {
        this.client.get('blocks/get', [id: id])
    }

    Object epoch()
    {
        this.client.get('blocks/getEpoch')
    }

    Object fee()
    {
        this.client.get('blocks/getFee')
    }

    Object fees()
    {
        this.client.get('blocks/getFees')
    }

    Object height()
    {
        this.client.get('blocks/getHeight')
    }

    Object milestone()
    {
        this.client.get('blocks/getMilestone')
    }

    Object nethash()
    {
        this.client.get('blocks/getNethash')
    }

    Object reward()
    {
        this.client.get('blocks/getReward')
    }

    Object status()
    {
        this.client.get('blocks/getStatus')
    }

    Object supply()
    {
        this.client.get('blocks/getSupply')
    }
}
