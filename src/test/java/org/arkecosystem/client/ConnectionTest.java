package org.arkecosystem.client;

import static junit.framework.TestCase.assertNotNull;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class ConnectionTest {
    @Test
    void apiTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");

        Connection connection = new Connection(map);
        assertNotNull(connection.api());
    }

    @Test
    void clientTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");

        Connection connection = new Connection(map);
        assertNotNull(connection.client());
    }
}
