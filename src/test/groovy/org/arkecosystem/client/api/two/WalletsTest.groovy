package org.arkecosystem.client.api.two

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class WalletsTest extends Specification {
    def "all"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('wallets').all()
        then:
            actual.success == true
    }

    def "show"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('wallets').show("dummy")
        then:
            actual.success == true
    }

    def "transactions"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('wallets').transactions("dummy")
        then:
            actual.success == true
    }

    def "sentTransactions"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('wallets').sentTransactions("dummy")
        then:
            actual.success == true
    }

    def "receivedTransactions"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('wallets').receivedTransactions("dummy")
        then:
            actual.success == true
    }

    def "votes"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('wallets').votes("dummy")
        then:
            actual.success == true
    }

    def "search"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('wallets').search()
        then:
            actual.success == true
    }

    def "top"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('wallets').top()
        then:
            actual.success == true
    }
}
