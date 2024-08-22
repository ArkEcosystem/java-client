package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.ArkClient;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class RoundsTest {

    @Test
    void delegates() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().rounds.delegates(12345);
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void all() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().rounds.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().rounds.param("page", 1).param("limit", 100).all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().rounds.show(12345);
        assertTrue((boolean) actual.get("success"));
    }
}