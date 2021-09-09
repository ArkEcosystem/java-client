package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

@SuppressWarnings("unchecked")
public class BlocksTest extends BaseClientTest {

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().blocks.all();
        assertThat(actual, hasKey("data"));
        assertThat(actual, hasKey("meta"));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
            connection.api().blocks.param("page", 1).param("limit", 100).all();
        assertThat(actual, hasKey("data"));
        assertThat(actual, hasKey("meta"));
    }

    @Test
    void first() throws IOException {
        Map<String, Object> actual = connection.api().blocks.first();
        assertThat(actual, hasKey("data"));
    }

    @Test
    void last() throws IOException {
        Map<String, Object> actual = connection.api().blocks.last();
        assertThat(actual, hasKey("data"));
    }

    @Test
    void showByHeight() throws IOException {
        Map<String, Object> actual = connection.api().blocks.show("1");
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("height", 1.0));
    }

    @Test
    void showByHash() throws IOException {
        Map<String, Object> actual = connection.api().blocks.show("13114381566690093367");
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("height", 1.0));
    }

    @Test
    void transactions() throws IOException {
        Map<String, Object> actual = connection.api().blocks.transactions("1");
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 52.0));
    }

    @Test
    void transactionsWithParams() throws IOException {
        Map<String, Object> actual =
            connection.api().blocks.param("page", 2).param("limit", 10).transactions("1");
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 10.0));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("pageCount", 7.0));
    }
}
