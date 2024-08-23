package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.ArkClient;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class BlocksTest {

    @Test
    void all() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().blocks.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void allWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().blocks.param("page", 1).param("limit", 100).all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void first() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().blocks.first();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void last() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().blocks.last();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().blocks.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactions() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().blocks.transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void transactionsWithParams() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual =
                client.api().blocks.param("page", 1).param("limit", 100).transactions("dummy");
        assertTrue((boolean) actual.get("success"));
    }
}
