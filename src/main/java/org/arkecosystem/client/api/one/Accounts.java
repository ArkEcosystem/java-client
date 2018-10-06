package org.arkecosystem.client.api.one;

import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Accounts {
    Client client;

    public Accounts(Client client) {
        this.client = client;
    }

    public Object all(Map query) throws IOException {
        return this.client.get("accounts/getAllAccounts", query);
    }

    public Object all() throws IOException {
        return this.all(new HashMap());
    }

    public Object show(String address) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("address", address);
        return this.client.get("accounts", map);
    }

    public Object count() throws IOException {
        return this.client.get("accounts/count");
    }

    public Object delegates(String address) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("address", address);
        return this.client.get("accounts/delegates", map);
    }

    public Object fee() throws IOException {
        return this.client.get("accounts/delegates/fee");
    }

    public Object balance(String address) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("address", address);
        return this.client.get("accounts/getBalance", map);
    }

    public Object publicKey(String address) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("address", address);
        return this.client.get("accounts/getPublicKey", map);
    }

    public Object top(Map query) throws IOException {
        return this.client.get("accounts/top", query);
    }

    public Object top() throws IOException {
        return top(new HashMap());
    }

}
