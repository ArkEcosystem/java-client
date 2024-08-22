package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.ArkClient;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class DelegatesTest {

    @Test
    void all() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().delegates.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().delegates.param("page", 1).param("limit", 100).all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().delegates.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void blocks() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().delegates.blocks("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void voters() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().delegates.voters("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void votersWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().delegates.param("page", 1).param("limit", 100).voters("dummy");
        assertTrue((boolean) actual.get("success"));
    }
}
