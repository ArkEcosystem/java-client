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

public class TransactionsTest {

    private Connection connection;

    @BeforeEach
    void setUp() {
        Map<String, Object> config = new HashMap<>();
        config.put("host", "https://ark-test.payvo.com/api/");

        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(config);

        connection = connectionManager.connection();
    }

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().transactions.all();
        assertThat(actual, hasKey("meta"));
        assertThat((Map<String, Object>) actual.get("meta"), hasEntry("count", 100.0));
    }

    @Test
    void create() throws IOException {
        Map<String, Object> actual = connection.api().transactions.create(new ArrayList<>());
        assertThat(actual, hasEntry("statusCode", 422.0));
    }

    @Test
    void show() throws IOException {
        Map<String, Object> actual = connection.api().transactions.show("25b3a02400893e1bc5dc800368287ca9a120ad12b793eda9ba7ec3f36cd8fb3a");
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, Object>) actual.get("data"), hasEntry("id", "25b3a02400893e1bc5dc800368287ca9a120ad12b793eda9ba7ec3f36cd8fb3a"));
    }

    @Test
    void allUnconfirmed() throws IOException {
        Map<String, Object> actual = connection.api().transactions.allUnconfirmed();
        assertThat(actual, hasKey("meta"));
        if (!((Map<String, Object>) actual.get("meta")).get("count").equals(0.0)) {
            List<Map<String, Object>> data = (List<Map<String, Object>>) actual.get("data");
            String id = (String) data.get(0).get("id");
            Map<String, Object> unconfirmed = connection.api().transactions.showUnconfirmed(id);
            assertThat(unconfirmed, notNullValue());
            assertThat(unconfirmed, instanceOf(Map.class));
        }
    }

    @Test
    void showUnconfirmed() throws IOException {
        Map<String, Object> actual = connection.api().transactions.showUnconfirmed("25b3a02400893e1bc5dc800368287ca9a120ad12b793eda9ba7ec3f36cd8fb3a");
        assertThat(actual, hasEntry("statusCode", 404.0));
    }

    @Test
    void types() throws IOException {
        Map<String, Object> actual = connection.api().transactions.types();
        assertThat(actual, hasKey("data"));
    }

    @Test
    void schemas() throws IOException {
        Map<String, Object> actual = connection.api().transactions.schemas();
        assertThat(actual, hasKey("data"));
    }

    @Test
    void fees() throws IOException {
        Map<String, Object> actual = connection.api().transactions.fees();
        assertThat(actual, hasKey("data"));
    }
}
