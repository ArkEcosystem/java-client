package api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

public class LocksTest extends BaseClientTest {

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().locks.all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().locks.param("page", 1).param("limit", 2).all();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 2.0));
    }

    @Test
    void show() throws IOException {
        Map<String, Object> actual = connection.api().locks.show("d8e7491055f5b34c0c954da9d4e184f1bdef3fbfe3dfc81d312c81899fbfc74d");
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("lockId", "d8e7491055f5b34c0c954da9d4e184f1bdef3fbfe3dfc81d312c81899fbfc74d"));
    }

    @Test
    void searchUnlocked() throws IOException {
        Map<String, Object> actual = connection.api().locks.searchUnlocked(Collections.singletonMap("ids", Collections.singletonList("d8e7491055f5b34c0c954da9d4e184f1bdef3fbfe3dfc81d312c81899fbfc74d")));
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 0.0));
    }

    @Test
    void searchUnlockedWithParams() throws IOException {
        Map<String, Object> actual = connection.api().locks.param("ids", Collections.singletonList("d8e7491055f5b34c0c954da9d4e184f1bdef3fbfe3dfc81d312c81899fbfc74d")).searchUnlocked();
        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 0.0));
    }
}
