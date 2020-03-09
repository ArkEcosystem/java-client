package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessesTest {

    @Test
    void all() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().businesses.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void show() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().businesses.show("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void showBridgechains() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().businesses.showBridgechains("dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void showBridgechain() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().businesses.showBridgechain("dummy", "dummy");
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    void search() throws IOException {
        Connection connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().businesses.search(new HashMap<>());
        assertTrue((boolean) actual.get("success"));
    }

}
