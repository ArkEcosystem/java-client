package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

public class RoundsIntegrationTest extends BaseClientTest {

    @Test
    void delegates() throws IOException {
        Map<String, Object> actual = connection.api().rounds.delegates(12345);
        assertThat(actual, hasKey("data"));
    }

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().rounds.all();
        assertThat(actual, hasKey("data"));
        assertThat(actual, hasKey("meta"));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().rounds.param("page", 1).param("limit", 100).all();
        assertThat(actual, hasKey("data"));
        assertThat(actual, hasKey("meta"));
    }

    @Test
    void show() throws IOException {
        Map<String, Object> actual = connection.api().rounds.show(12345);
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("id", 12345.0));
    }
}
