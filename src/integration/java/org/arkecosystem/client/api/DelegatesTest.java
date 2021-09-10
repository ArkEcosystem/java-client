package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

@SuppressWarnings("unchecked")
public class DelegatesTest extends BaseClientTest {

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().delegates.all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 100.0));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().delegates.param("page", 2).param("limit", 10).all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 10.0));
    }

    @Test
    void show() throws IOException {
        Map<String, Object> actual = connection.api().delegates.show("we.miss.you.elaine");
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("username", "we.miss.you.elaine"));
    }

    @Test
    void blocks() throws IOException {
        Map<String, Object> actual = connection.api().delegates.blocks("we.miss.you.elaine");
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 100.0));
    }

    @Test
    void voters() throws IOException {
        Map<String, Object> actual = connection.api().delegates.voters("we.miss.you.elaine");
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasKey("count"));
    }

    @Test
    void votersWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().delegates.param("page", 2).param("limit", 5).voters("we.miss.you.elaine");
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 5.0));
    }
}
