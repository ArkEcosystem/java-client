package org.arkecosystem.client.api;

import org.arkecosystem.client.http.Client;

public class Api {

    public final Blockchain blockchain;
    public final Blocks blocks;
    public final Delegates delegates;
    public final Entities entities;
    public final Locks locks;
    public final Node node;
    public final Peers peers;
    public final Rounds rounds;
    public final Transactions transactions;
    public final Votes votes;
    public final Wallets wallets;

    public Api(Client client) {
        this.blockchain = new Blockchain(client);
        this.blocks = new Blocks(client);
        this.delegates = new Delegates(client);
        this.entities = new Entities(client);
        this.locks = new Locks(client);
        this.node = new Node(client);
        this.peers = new Peers(client);
        this.rounds = new Rounds(client);
        this.transactions = new Transactions(client);
        this.votes = new Votes(client);
        this.wallets = new Wallets(client);
    }
}
