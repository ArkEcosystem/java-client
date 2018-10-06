package org.arkecosystem.client.api.one;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountsTest {

    @Test
    public void all() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().accounts.all();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void show() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().accounts.show("dummy");
        assertTrue((boolean)actual.get("success"));
    }


    @Test
    public void count() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().accounts.count();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void delegates() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().accounts.delegates("dummy");
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void fee() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().accounts.fee();
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void balance() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().accounts.balance("dummy");
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void publicKey() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().accounts.publicKey("dummy");
        assertTrue((boolean)actual.get("success"));
    }

    @Test
    public void top() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().accounts.top();
        assertTrue((boolean)actual.get("success"));
    }

}
