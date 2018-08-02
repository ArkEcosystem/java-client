package org.arkecosystem.client.api.two

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class PeersTest extends Specification {
    def "all"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('peers').all()
        then:
            actual.success == true
    }

    def "show"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('peers').show("dummy")
        then:
            actual.success == true
    }
}
