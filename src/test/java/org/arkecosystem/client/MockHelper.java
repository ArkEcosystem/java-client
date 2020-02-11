package org.arkecosystem.client;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import java.util.HashMap;

public class MockHelper {
    public static Connection connection() {
        /* MockWebServer mockServer = new MockWebServer();

        HashMap<String, Object> map = new HashMap<>();
        map.put("host", mockServer.url("/").toString());
        Connection connection = new Connection(map);

        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(200);
        mockedResponse.setBody("{\"success\":true}");

        mockServer.enqueue(mockedResponse);

         */

        HashMap<String, Object> map = new HashMap<>();
        map.put("host", "http://137.74.27.246:4003/api/");
        map.put("content-type","application/json");
        Connection connection = new Connection(map);
        return connection;
    }
}
