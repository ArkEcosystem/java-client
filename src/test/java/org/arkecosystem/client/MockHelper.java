package org.arkecosystem.client;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.util.HashMap;

public class MockHelper {
    public static Connection connection() {
        MockWebServer mockServer = new MockWebServer();

        HashMap<String, Object> map = new HashMap<>();
        map.put("host", mockServer.url("/").toString());
        Connection connection = new Connection(map);

        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(200);
        mockedResponse.setBody("{\"success\":true}");

        mockServer.enqueue(mockedResponse);

        return connection;
    }
}
