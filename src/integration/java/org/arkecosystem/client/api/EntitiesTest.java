package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

@SuppressWarnings("unchecked")
public class EntitiesTest extends BaseClientTest {

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().entities.all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().entities.param("page", 1).param("limit", 2).all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 2.0));
    }

    @Test
    void show() throws IOException {
        Map<String, Object> actual = connection.api().entities.show("c2ef39c3fb7aae83fcba03448c156e7777a520a04838cb974c0d31b51da26b04");
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("id", "c2ef39c3fb7aae83fcba03448c156e7777a520a04838cb974c0d31b51da26b04"));
    }
}
