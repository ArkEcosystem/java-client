package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class BlocksTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().blocks.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().blocks
            .param("page", 1)
            .param("limit", 100)
            .all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void first() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().blocks.first();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void last() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().blocks.last();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().blocks.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactions() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().blocks.transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactionsWithParams() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().blocks
            .param("page", 1)
            .param("limit", 100)
            .transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }
}
