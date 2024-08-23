package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.ArkClient;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class WalletsTest {

    @Test
    void all() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().wallets.param("page", 1).param("limit", 100).all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactions() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactionsWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.param("page", 1).transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void sentTransactions() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.sentTransactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void sentTransactionsWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().wallets.param("page", 1).sentTransactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void receivedTransactions() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.receivedTransactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void receivedTransactionsWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().wallets.param("page", 1).receivedTransactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void votes() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.votes("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void votesWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.param("page", 1).votes("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void top() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.top();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void topWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().wallets.param("page", 1).top();
        assertTrue((boolean) actual.get("success"));
    }
}
