package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;

@SuppressWarnings("unchecked")
public class CommitsIntegrationTest extends BaseClientTest {

    @Test
    void show() throws IOException {
        Map<String, Object> actual = connection.api().commits.show(123456);
        assertThat(actual, hasKey("data"));
    }
}
