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
public class PeersTest extends BaseClientTest {

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().peers.all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
            connection.api().peers.param("page", 1).param("limit", 2).all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 2.0));
    }

    @Test
    void show() throws IOException {
        Map<String, Object> allPeers =
            connection.api().peers.param("page", 1).param("limit", 2).all();
        List<?> data = (List<?>) allPeers.get("data");
        Map<String, Object> knownPeer = (Map<String, Object>) data.get(0);

        Map<String, Object> actual = connection.api().peers.show((String) knownPeer.get("ip"));
        System.out.println(actual);
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("ip", knownPeer.get("ip")));
    }
}
