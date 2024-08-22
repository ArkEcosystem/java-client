package org.arkecosystem.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ArkClientTest {

    @Test
    void apiTest() {
        HashMap<String, Object> config = new HashMap<>();
        config.put("host", "dummy");

        ArkClient client = new ArkClient(config.get("host").toString());
        assertNotNull(client.api());
    }

    @Test
    void clientTest() {
        HashMap<String, Object> config = new HashMap<>();
        config.put("host", "dummy");

        ArkClient client = new ArkClient(config.get("host").toString());
        assertNotNull(client.client());
    }

    @Test
    void shouldAcceptHostsAsArray() {
        Map<String, String> hosts = new HashMap<>();
        hosts.put("api", "https://dwallets-evm.mainsailhq.com/api");
        hosts.put("transactions", "https://dwallets-evm.mainsailhq.com/tx/api");
        hosts.put("evm", "https://dwallets-evm.mainsailhq.com/evm");

        ArkClient client = new ArkClient(hosts);
        assertEquals(hosts, client.getHosts());
    }

    @Test
    void doesNotAcceptHostsArrayWithoutApi() {
        Map<String, String> hosts = new HashMap<>();
        hosts.put("transactions", "https://dwallets-evm.mainsailhq.com/tx/api");
        hosts.put("evm", "https://dwallets-evm.mainsailhq.com/evm");

        assertThrows(IllegalArgumentException.class, () -> new ArkClient(hosts));
    }

    @Test
    void shouldSetHost() {
        ArkClient client = new ArkClient("https://old-host.com/api");

        String newHost = "https://new-host.com/api";
        client.setHost(newHost, "api");

        assertEquals(newHost, client.getHosts().get("api"));
    }

    @Test
    void shouldThrowExceptionIfHostTypeIsInvalid() {
        ArkClient client = new ArkClient("https://old-host.com/api");

        assertThrows(
                IllegalArgumentException.class,
                () -> client.setHost("https://new-host.com/api", "other"));
    }
}
