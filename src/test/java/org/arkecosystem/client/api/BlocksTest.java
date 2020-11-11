package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class BlocksTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void first() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.first();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void last() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.last();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactions() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }
}
