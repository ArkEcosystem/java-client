package org.arkecosystem.client.api.one

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class PeersTest extends Specification {
    def "all"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('peers').all()
        then:
            actual.success == true
    }

    def "show"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('peers').show("ip", 1234)
        then:
            actual.success == true
    }

    def "version"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('peers').version()
        then:
            actual.success == true
    }
}
