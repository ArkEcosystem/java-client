package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.ArkClient;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    void feesWithDays() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().node.fees(1);
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void fees() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().node.fees();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void status() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().node.status();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void syncing() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().node.syncing();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void configuration() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().node.configuration();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void crypto() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().node.crypto();
        assertTrue((boolean) actual.get("success"));
    }
}