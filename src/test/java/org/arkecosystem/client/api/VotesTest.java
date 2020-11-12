package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class VotesTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().votes.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        Map<String, Object> actual = connection.api().votes.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }
}
