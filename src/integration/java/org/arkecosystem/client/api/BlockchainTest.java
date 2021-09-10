package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;

public class BlockchainTest extends BaseClientTest {

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().blockchain.all();
        assertThat(actual, hasKey("data"));
    }

}
