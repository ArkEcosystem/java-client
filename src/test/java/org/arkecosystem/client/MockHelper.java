package org.arkecosystem.client;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.arkecosystem.client.api.AbstractAPI;

import java.util.HashMap;

public class MockHelper {
    public static Connection connection(int version) {
        MockWebServer mockServer = new MockWebServer();

        HashMap<String, Object> map = new HashMap<>();
        map.put("host", mockServer.url("/").toString());
        map.put("version", version);
        Connection connection = new Connection(map);

        MockResponse mockedResponse = new MockResponse();
        mockedResponse.setResponseCode(200);
        mockedResponse.setBody("{\"success\":true}");

        mockServer.enqueue(mockedResponse);

        return connection;
    }

    public static <T extends AbstractAPI> Connection<T> connection() {
        return (Connection<T>)MockHelper.connection(1);
    }

}
