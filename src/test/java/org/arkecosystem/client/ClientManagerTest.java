package org.arkecosystem.client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ClientManagerTest {

    @Test
    public void connect() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");

        ClientManager manager = new ClientManager();
        manager.connect(map.get("host").toString(), "dummy-client");
        assertEquals(1, manager.getClients().size());
        assertTrue(manager.getClients().containsKey("dummy-client"));
    }

    @Test
    public void shouldThrowIfClientAlreadyExists() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");

        ClientManager manager = new ClientManager();
        manager.connect(map.get("host").toString(), "dummy-client");

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    manager.connect(map.get("host").toString(), "dummy-client");
                });
    }

    @Test
    public void disconnect() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");

        ClientManager manager = new ClientManager();
        manager.connect(map.get("host").toString(), "dummy-client");
        assertEquals(1, manager.getClients().size());

        manager.disconnect("dummy-client");
        assertEquals(0, manager.getClients().size());
    }

    @Test
    public void client() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "dummy");

        ClientManager manager = new ClientManager();
        manager.connect(map.get("host").toString(), "dummy-client");
        ArkClient client = manager.client("dummy-client");
        assertNotNull(client);
    }

    @Test
    public void shouldThrowIfClientDoesNotExist() {
        ClientManager manager = new ClientManager();

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    manager.client("non-existent-client");
                });
    }

    @Test
    public void getDefaultClient() {
        ClientManager manager = new ClientManager();
        String actual = manager.getDefaultClient();
        assertEquals("main", actual);
    }

    @Test
    public void setDefaultClient() {
        ClientManager manager = new ClientManager();
        assertEquals("main", manager.getDefaultClient());
        manager.setDefaultClient("dummy-client");
        assertEquals("dummy-client", manager.getDefaultClient());
    }

    @Test
    public void getClients() {
        ClientManager manager = new ClientManager();

        manager.connect("https://dummy1.com", "dummy-client-1");
        manager.connect("https://dummy2.com", "dummy-client-2");
        manager.connect("https://dummy3.com", "dummy-client-3");

        assertEquals(3, manager.getClients().size());
        assertTrue(manager.getClients().containsKey("dummy-client-1"));
        assertTrue(manager.getClients().containsKey("dummy-client-2"));
        assertTrue(manager.getClients().containsKey("dummy-client-3"));

        manager.disconnect("dummy-client-1");
        manager.disconnect("dummy-client-2");
        manager.disconnect("dummy-client-3");

        assertEquals(0, manager.getClients().size());
    }
}
