package org.arkecosystem.client.api;

import org.arkecosystem.client.http.Client;

public class Api {
    public Blocks blocks;
    public Delegates delegates;
    public Node node;
    public Peers peers;
    public Rounds rounds;
    public Transactions transactions;
    public Votes votes;
    public Wallets wallets;

    public Api(Client client) {
        this.blocks = new Blocks(client);
        this.delegates = new Delegates(client);
        this.node = new Node(client);
        this.peers = new Peers(client);
        this.rounds = new Rounds(client);
        this.transactions = new Transactions(client);
        this.votes = new Votes(client);
        this.wallets = new Wallets(client);
    }
}
