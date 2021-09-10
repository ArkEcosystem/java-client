package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

@SuppressWarnings("unchecked")
public class VotesTest extends BaseClientTest {

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().votes.all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().votes.param("page", 2).param("limit", 2).all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 2.0));
    }

    @Test
    void show() throws IOException {
        Map<String, Object> votes =
            connection.api().votes.param("page", 1).param("limit", 2).all();
        List<?> data = (List<?>) votes.get("data");
        Map<String, Object> knownVote = (Map<String, Object>) data.get(0);

        Map<String, Object> actual = connection.api().votes.show((String) knownVote.get("id"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("id", knownVote.get("id")));
    }
}
