package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class DelegatesTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().delegates.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().delegates
            .param("page", 1)
            .param("limit", 100)
            .all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().delegates.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void blocks() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().delegates.blocks("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void voters() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().delegates.voters("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void votersWithParams() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().delegates
            .param("page", 1)
            .param("limit", 100)
            .voters("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void search() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().delegates.search(new HashMap<>());
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void searchWithParams() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().delegates
            .param("page", 1)
            .param("limit", 100)
            .search();
        assertTrue((boolean) actual.get("success"));
    }
}
