package org.arkecosystem.client.api.one;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeersTest {

    @Test
    public void all() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().peers.all();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void show() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().peers.show("ip", 1234);
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void version() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().peers.version();
        assertTrue((boolean)actual.get("success"));
    }

}
