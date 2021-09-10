package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;

public class RoundsTest extends BaseClientTest {

    @Test
    void delegates() throws IOException {
        Map<String, Object> actual = connection.api().rounds.delegates(12345);
        assertThat(actual, hasKey("data"));
    }
}
