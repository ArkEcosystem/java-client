package api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

public class NodeTest extends BaseClientTest {

    @Test
    void feesWithDays() throws IOException {
        Map<String, Object> actual = connection.api().node.fees(1);
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("days", 1.0));
    }

    @Test
    void fees() throws IOException {
        Map<String, Object> actual = connection.api().node.fees();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasKey("1"));
    }

    @Test
    void status() throws IOException {
        Map<String, Object> actual = connection.api().node.status();
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasKey("synced"));
    }

    @Test
    void syncing() throws IOException {
        Map<String, Object> actual = connection.api().node.syncing();
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasKey("syncing"));
    }

    @Test
    void configuration() throws IOException {
        Map<String, Object> actual = connection.api().node.configuration();
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("token", "DARK"));
    }

    @Test
    void crypto() throws IOException {
        Map<String, Object> actual = connection.api().node.crypto();
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasKey("network"));
    }
}
