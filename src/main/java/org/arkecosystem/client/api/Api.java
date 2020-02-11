package org.arkecosystem.client.api;

import org.arkecosystem.client.http.Client;

public class Api {

    public Blockchain blockchain;
    public Blocks blocks;
    public Bridgechains bridgechains;
    public Businesses businesses;
    public Delegates delegates;
    public Locks locks;
    public Node node;
    public Peers peers;
    public Rounds rounds;
    public Transactions transactions;
    public Votes votes;
    public Wallets wallets;

    public Api(Client client) {
        this.blockchain = new Blockchain(client);
        this.blocks = new Blocks(client);
        this.bridgechains = new Bridgechains(client);
        this.businesses = new Businesses(client);
        this.delegates = new Delegates(client);
        this.locks = new Locks(client);
        this.node = new Node(client);
        this.peers = new Peers(client);
        this.rounds = new Rounds(client);
        this.transactions = new Transactions(client);
        this.votes = new Votes(client);
        this.wallets = new Wallets(client);
    }
}
