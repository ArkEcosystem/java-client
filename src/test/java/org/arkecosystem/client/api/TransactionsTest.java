package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.arkecosystem.client.ArkClient;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class TransactionsTest {

    @Test
    void all() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().transactions.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().transactions.param("page", 1).param("limit", 100).all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void create() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().transactions.create(new ArrayList<>());
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().transactions.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allUnconfirmed() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().transactions.allUnconfirmed();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allUnconfirmedWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().transactions.param("page", 1).allUnconfirmed();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void showUnconfirmed() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().transactions.showUnconfirmed("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void types() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().transactions.types();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void fees() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().transactions.fees();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void schemas() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().transactions.schemas();
        assertTrue((boolean) actual.get("success"));
    }
}