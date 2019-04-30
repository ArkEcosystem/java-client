package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodeTest {

    @Test
    void status() throws IOException {
        Connection connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().node.status();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void syncing() throws IOException {
        Connection connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().node.syncing();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void configuration() throws IOException {
        Connection connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().node.configuration();
        assertTrue((boolean) actual.get("success"));
    }

}
