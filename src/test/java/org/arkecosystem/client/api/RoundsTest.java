package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class RoundsTest {

    @Test
    void delegates() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().rounds.delegates(12345);
        assertTrue((boolean) actual.get("success"));
    }
}
