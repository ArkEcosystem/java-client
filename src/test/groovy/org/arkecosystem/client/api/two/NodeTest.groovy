package org.arkecosystem.client.api.two

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class NodeTest extends Specification {
    def "status"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('node').status()
        then:
            actual.success == true
    }

    def "syncing"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('node').syncing()
        then:
            actual.success == true
    }

    def "configuration"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('node').configuration()
        then:
            actual.success == true
    }
}
