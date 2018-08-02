package org.arkecosystem.client

import spock.lang.Specification
import org.arkecosystem.client.*

class ConnectionManagerTest extends Specification {
    def "connect"() {
        setup:
            def manager = new ConnectionManager()
        when:
            def connection = manager.connect([host: 'dummy',  version: 1])
        then:
            connection
    }

    def "disconnect"() {
        setup:
            def manager = new ConnectionManager()
        when:
            manager.connect([host: 'dummy',  version: 1])
        then:
            manager.connection('main')
            manager.getConnections().size() == 1
            manager.disconnect()
            manager.getConnections().size() == 0
    }

    def "connection"() {
        setup:
            def manager = new ConnectionManager()
        when:
            manager.connect([host: 'dummy',  version: 1])
        then:
            manager.connection('main')
    }

    def "getDefaultConnection"() {
        setup:
            def manager = new ConnectionManager()
        when:
            def actual = manager.getDefaultConnection()
        then:
            actual == 'main'
    }

    def "setDefaultConnection"() {
        setup:
            def manager = new ConnectionManager()
        when:
            manager.connect([host: 'dummy',  version: 1])
        then:
            manager.getDefaultConnection() == 'main'
            manager.setDefaultConnection('dummy')
            manager.getDefaultConnection() == 'dummy'
    }

    def "getConnections"() {
        setup:
            def manager = new ConnectionManager()
        when:
            manager.connect([host: 'dummy',  version: 1])
        then:
            manager.getConnections().size() == 1
            manager.disconnect()
            manager.getConnections().size() == 0
    }
}
