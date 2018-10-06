package org.arkecosystem.client.api.one;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlocksTest {

    @Test
    public void all() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.all();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void show() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.show("dummy");
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void epoch() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.epoch();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void fee() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.fee();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void fees() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.fees();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void height() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.height();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void milestone() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.milestone();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void nethash() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.nethash();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void reward() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.reward();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void status() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.status();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void supply() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().blocks.supply();
        assertTrue((boolean)actual.get("success"));
    }

}
