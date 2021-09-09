package org.arkecosystem.client;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseClientTest {

    protected Connection connection;

    @BeforeEach
    public void setUp() {
        Map<String, Object> config = new HashMap<>();
        config.put("host", "https://ark-test.payvo.com/api/");

        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(config);

        connection = connectionManager.connection();
    }
}
