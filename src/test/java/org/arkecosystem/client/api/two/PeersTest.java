package org.arkecosystem.client.api.two;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeersTest {

    @Test
    void all() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().peers.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection<Two> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().peers.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

}
