package org.arkecosystem.client.api.two;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletsTest {

    @Test
    void all() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().wallets.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().wallets.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactions() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().wallets.transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void sentTransactions() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().wallets.sentTransactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void receivedTransactions() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().wallets.receivedTransactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void votes() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().wallets.votes("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void search() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().wallets.search(new HashMap<>());
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void top() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().wallets.top();
        assertTrue((boolean) actual.get("success"));
    }

}
