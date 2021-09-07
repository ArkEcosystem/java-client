package api;

import org.arkecosystem.client.Connection;
import org.arkecosystem.client.ConnectionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseClientTest {

    protected Connection connection;

    @BeforeEach
    void setUp() {
        Map<String, Object> config = new HashMap<>();
        config.put("host", "https://ark-test.payvo.com/api/");

        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(config);

        connection = connectionManager.connection();
    }
}
