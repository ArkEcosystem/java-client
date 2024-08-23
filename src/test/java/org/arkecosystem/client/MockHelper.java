package org.arkecosystem.client;

import java.util.HashMap;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class MockHelper {
    public static ArkClient client() {
        MockWebServer mockServer = new MockWebServer();

        Map<String, String> hosts = new HashMap<>();
        hosts.put("api", mockServer.url("/api").toString());
        hosts.put("transactions", mockServer.url("/transactions").toString());
        hosts.put("evm", mockServer.url("/evm").toString());

        ArkClient client = new ArkClient(hosts);

        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(200);
        mockedResponse.setBody("{\"success\":true}");

        mockServer.enqueue(mockedResponse);

        return client;
    }
}
