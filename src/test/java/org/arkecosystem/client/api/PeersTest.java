package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.ArkClient;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class PeersTest {

    @Test
    void all() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().peers.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().peers.param("page", 1).param("limit", 100).all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().peers.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }
}