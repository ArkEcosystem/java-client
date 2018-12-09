package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VotesTest {

    @Test
    void all() throws IOException {
        Connection<Api> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().votes.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection<Api> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().votes.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

}
