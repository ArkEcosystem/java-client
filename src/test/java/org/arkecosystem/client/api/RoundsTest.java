package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class RoundsTest {

    @Test
    void delegates() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().rounds.delegates(12345);
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().rounds.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual =
                connection.api().rounds.param("page", 1).param("limit", 100).all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().rounds.show(12345);
        assertTrue((boolean) actual.get("success"));
    }
}
