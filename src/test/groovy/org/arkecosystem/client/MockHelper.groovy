package org.arkecosystem.client

import okhttp3.mockwebserver.*

class MockHelper {
    static Connection connection(int version = 1) {
        MockWebServer mockServer = new MockWebServer()

        Connection connection = new Connection([
            host: mockServer.url('/').toString(),
            version: version
        ])

        MockResponse mockedResponse = new MockResponse()
        mockedResponse.setResponseCode(200)
        mockedResponse.setBody("{\"success\":true}")

        mockServer.enqueue(mockedResponse)

        connection
    }
}
