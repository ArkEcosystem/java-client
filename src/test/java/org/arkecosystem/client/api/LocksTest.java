package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class LocksTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().locks.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().locks.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void searchUnlocked() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual =
                connection.api().locks.searchUnlocked(new HashMap<>());
        assertTrue((boolean) actual.get("success"));
    }
}
