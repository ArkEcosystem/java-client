package org.arkecosystem.client.api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.ArkClient;
import org.arkecosystem.client.MockHelper;
import org.junit.jupiter.api.Test;

public class CommitsTest {

    @Test
    void show() throws IOException {
        ArkClient client = MockHelper.client();
        Map<String, Object> actual = client.api().commits.show(123456);
        assertTrue((boolean) actual.get("success"));
    }
}