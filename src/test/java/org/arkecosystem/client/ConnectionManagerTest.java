package org.arkecosystem.client;

import org.arkecosystem.client.api.Api;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectionManagerTest {
    @Test
    public void connect() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");
        map.put("API-Version", 1);

        ConnectionManager manager = new ConnectionManager();
        manager.connect(map);
        assertEquals(1, manager.getConnections().size());
    }

    @Test
    public void disconnect() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");
        map.put("API-Version", 1);

        ConnectionManager manager = new ConnectionManager();
        manager.connect(map);
        assertEquals(1, manager.getConnections().size());
        manager.disconnect();
        assertEquals(0, manager.getConnections().size());
    }

    @Test
    public void connection() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");
        map.put("API-Version", 1);

        ConnectionManager manager = new ConnectionManager();
        manager.connect(map);
        Connection connection = manager.connection("main");
        assertNotNull(connection);
        assertEquals(Api.class, connection.api().getClass());
    }

    @Test
    public void getDefaultConnection() {
        ConnectionManager manager = new ConnectionManager();
        String actual = manager.getDefaultConnection();
        assertEquals("main", actual);
    }

    @Test
    public void setDefaultConnection() {
        ConnectionManager manager = new ConnectionManager();
        assertEquals("main", manager.getDefaultConnection());
        manager.setDefaultConnection("dummy");
        assertEquals("dummy", manager.getDefaultConnection());
    }

    @Test
    public void getConnections() {
        ConnectionManager manager = new ConnectionManager();

        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");
        map.put("API-Version", 1);

        Connection connection1 = manager.connect(map);
        assertNotNull(connection1);

        map = new HashMap<>();
        map.put("host", "dummy");
        map.put("API-Version", 2);

        Connection connection2 = manager.connect(map, "backup");
        assertNotNull(connection2);

        assertEquals(2, manager.getConnections().size());
        manager.disconnect();
        manager.disconnect("backup");
        assertEquals(0, manager.getConnections().size());
    }
}
