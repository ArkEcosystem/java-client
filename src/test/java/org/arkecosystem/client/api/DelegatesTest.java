package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DelegatesTest {

    @Test
    void all() throws IOException {
        Connection<Api> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().delegates.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection<Api> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().delegates.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void blocks() throws IOException {
        Connection<Api> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().delegates.blocks("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void voters() throws IOException {
        Connection<Api> connection = MockHelper.connection(2);
        LinkedTreeMap<String, Object> actual = connection.api().delegates.voters("dummy");
        assertTrue((boolean) actual.get("success"));
    }

}
