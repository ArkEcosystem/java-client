package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionsTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void create() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.create(new ArrayList<>());
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allUnconfirmed() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.allUnconfirmed();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void showUnconfirmed() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.showUnconfirmed("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void search() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.search(new HashMap<>());
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void types() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.types();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void fees() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.fees();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void schemas() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.schemas();
        assertTrue((boolean) actual.get("success"));
    }
}
