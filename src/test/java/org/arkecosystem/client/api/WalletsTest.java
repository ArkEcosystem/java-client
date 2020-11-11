package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.HashMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class WalletsTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().wallets.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().wallets.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactions() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().wallets.transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void sentTransactions() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().wallets.sentTransactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void receivedTransactions() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual =
                connection.api().wallets.receivedTransactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void votes() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().wallets.votes("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void locks() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().wallets.locks("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void top() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().wallets.top();
        assertTrue((boolean) actual.get("success"));
    }
}
