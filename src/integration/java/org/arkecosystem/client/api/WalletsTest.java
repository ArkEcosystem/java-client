package org.arkecosystem.client.api;

import org.arkecosystem.client.BaseClientTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

@SuppressWarnings("unchecked")
public class WalletsTest extends BaseClientTest {

    private static final Logger logger = LoggerFactory.getLogger(WalletsTest.class);

    @Test
    void all() throws IOException {
        Map<String, Object> actual = connection.api().wallets.all();
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 100.0));
    }

    @Test
    void allWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().wallets.param("page", 1).param("limit", 5).all();
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 5.0));
    }

    @Test
    void show() throws IOException {
        Map<String, Object> actual = connection.api().wallets.show("D6Z26L69gdk9qYmTv5uzk3uGepigtHY4ax");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("data"), hasEntry("address", "D6Z26L69gdk9qYmTv5uzk3uGepigtHY4ax"));
    }

    @Test
    void transactions() throws IOException {
        Map<String, Object> actual = connection.api().wallets.transactions("D6Z26L69gdk9qYmTv5uzk3uGepigtHY4ax");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 100.0));
    }

    @Test
    void transactionsWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().wallets.param("limit", 2).transactions("D6Z26L69gdk9qYmTv5uzk3uGepigtHY4ax");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 2.0));
    }

    @Test
    void sentTransactions() throws IOException {
        Map<String, Object> actual = connection.api().wallets.sentTransactions("D6Z26L69gdk9qYmTv5uzk3uGepigtHY4ax");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 100.0));
    }

    @Test
    void sentTransactionsWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().wallets.param("limit", 5).sentTransactions("D6Z26L69gdk9qYmTv5uzk3uGepigtHY4ax");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 5.0));
    }

    @Test
    void receivedTransactions() throws IOException {
        Map<String, Object> actual = connection.api().wallets.receivedTransactions("DEyaFhDuaoQyKbFH4gJtYZvKkB6umyrEUj");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 100.0));
    }

    @Test
    void receivedTransactionsWithParams() throws IOException {
        Map<String, Object> actual =
                connection.api().wallets.param("limit", 5).receivedTransactions("D6Z26L69gdk9qYmTv5uzk3uGepigtHY4ax");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 5.0));
    }

    @Test
    void votes() throws IOException {
        Map<String, Object> actual = connection.api().wallets.votes("DEyaFhDuaoQyKbFH4gJtYZvKkB6umyrEUj");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasKey("count"));
    }

    @Test
    void votesWithParams() throws IOException {
        Map<String, Object> actual = connection.api().wallets.param("limit", 3).votes("DEyaFhDuaoQyKbFH4gJtYZvKkB6umyrEUj");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 3.0));
    }

    @Test
    void locks() throws IOException {
        Map<String, Object> actual = connection.api().wallets.locks("D6i8P5N44rFto6M6RALyUXLLs7Q1A1WREW");
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 0.0));
    }

    @Test
    void top() throws IOException {
        Map<String, Object> actual = connection.api().wallets.top();
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 100.0));
    }

    @Test
    void topWithParams() throws IOException {
        Map<String, Object> actual = connection.api().wallets.param("limit", 5).top();
        logger.info("actual: {}", actual);

        assertThat(actual, hasKey("meta"));
        assertThat(actual, hasKey("data"));
        assertThat((Map<String, ?>) actual.get("meta"), hasEntry("count", 5.0));
    }
}
