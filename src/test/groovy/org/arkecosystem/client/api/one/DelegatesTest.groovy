package org.arkecosystem.client.api.one

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class DelegatesTest extends Specification {
    def "all"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('delegates').all()
        then:
            actual.success == true
    }

    def "show"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('delegates').show([username: "dummy"])
        then:
            actual.success == true
    }

    def "count"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('delegates').count()
        then:
            actual.success == true
    }

    def "fee"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('delegates').fee()
        then:
            actual.success == true
    }

    def "forgedByAccount"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('delegates').forgedByAccount()
        then:
            actual.success == true
    }

    def "search"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('delegates').search("dummy")
        then:
            actual.success == true
    }

    def "voters"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('delegates').voters("dummy")
        then:
            actual.success == true
    }

    def "nextForgers"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('delegates').nextForgers()
        then:
            actual.success == true
    }
}
