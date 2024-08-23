package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

@SuppressWarnings("unchecked")
public class ApiNodesIntegrationTest extends BaseClientTest {

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().apiNodes.all();
        assertThat(actual, hasKey("data"));
        assertThat(actual, hasKey("meta"));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
            connection.api().apiNodes.param("page", 1).param("limit", 100).all();
        assertThat(actual, hasKey("data"));
        assertThat(actual, hasKey("meta"));
    }
}
