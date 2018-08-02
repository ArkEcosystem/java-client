package org.arkecosystem.client.api.one

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class AccountsTest extends Specification {
    def "all"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('accounts').all()
        then:
            actual.success == true
    }

    def "show"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('accounts').show("dummy")
        then:
            actual.success == true
    }

    def "count"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('accounts').count()
        then:
            actual.success == true
    }

    def "delegates"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('accounts').delegates("dummy")
        then:
            actual.success == true
    }

    def "fee"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('accounts').fee()
        then:
            actual.success == true
    }

    def "balance"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('accounts').balance("dummy")
        then:
            actual.success == true
    }

    def "publicKey"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('accounts').publicKey("dummy")
        then:
            actual.success == true
    }

    def "top"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('accounts').top()
        then:
            actual.success == true
    }
}
