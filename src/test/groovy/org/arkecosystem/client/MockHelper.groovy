package org.arkecosystem.client

import okhttp3.mockwebserver.*

class MockHelper {
    static Connection connection(int version = 1) {
        MockWebServer mockBackend = new MockWebServer()

        Connection connection = new Connection([
            host: mockBackend.url('/').toString(),
            version: version
        ])

        mockBackend.enqueue(new MockResponse().setBody("{\"success\":true}"))

        connection
    }
}
