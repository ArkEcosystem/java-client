package org.arkecosystem.client.api.one;

import com.google.gson.internal.LinkedTreeMap;
import org.arkecosystem.client.Connection;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionsTest {

    @Test
    public void all() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.all();
        assertTrue((boolean) actual.get("success"));
    }

    @Test
    public void show() throws IOException {
        Connection<One> connection = MockHelper.connection();
        LinkedTreeMap<String, Object> actual = connection.api().transactions.show("038716f2d525f2f1a4f02f85b7e51c7cf46420c1505ffceee7495b5271a205ad");
        assertTrue((boolean) actual.get("success"));
    }

}
