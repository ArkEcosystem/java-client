package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.HashMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class BridgechainsTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().bridgechains.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void search() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual =
                connection.api().bridgechains.search(new HashMap<>());
        assertTrue((boolean) actual.get("success"));
    }
}
