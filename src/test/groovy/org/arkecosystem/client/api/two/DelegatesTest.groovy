package org.arkecosystem.client.api.two

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class DelegatesTest extends Specification {
    def "all"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('delegates').all()
        then:
            actual.success == true
    }

    def "show"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('delegates').show("dummy")
        then:
            actual.success == true
    }

    def "blocks"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('delegates').blocks("dummy")
        then:
            actual.success == true
    }

    def "voters"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('delegates').voters("dummy")
        then:
            actual.success == true
    }
}
