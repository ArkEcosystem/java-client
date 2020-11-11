package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    void feesWithDays() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().node.fees(1);
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void fees() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().node.fees();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void status() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().node.status();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void syncing() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().node.syncing();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void configuration() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().node.configuration();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void crypto() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().node.crypto();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void debug() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().node.debug();
        assertTrue((boolean) actual.get("success"));
    }
}
