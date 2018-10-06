package org.arkecosystem.client.api.one;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DelegatesTest {

    @Test
    public void all() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().delegates.all();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void show() throws IOException {
        Connection<One> connection = MockHelper.connection();
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "dummy");
        LinkedTreeMap<String, Object> actual = connection.api().delegates.show(map);
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void count() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().delegates.count();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void fee() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().delegates.fee();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void forgedByAccount() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().delegates.forgedByAccount("dummy");
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void search() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().delegates.search("dummy");
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void voters() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().delegates.voters("dummy");
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void nextForgers() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().delegates.nextForgers();
        assertTrue((boolean)actual.get("success"));
    }

}
