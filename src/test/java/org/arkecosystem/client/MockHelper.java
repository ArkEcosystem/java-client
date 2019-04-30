package org.arkecosystem.client;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.util.HashMap;

public class MockHelper {
    public static Connection connection(int version) {
        MockWebServer mockServer = new MockWebServer();

        HashMap<String, Object> map = new HashMap<>();
        map.put("host", mockServer.url("/").toString());
        map.put("API-Version", version);
        Connection connection = new Connection(map);

        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(200);
        mockedResponse.setBody("{\"success\":true}");

        mockServer.enqueue(mockedResponse);

        return connection;
    }

    public static Connection connection() {
        return (Connection) MockHelper.connection(2);
    }

}
