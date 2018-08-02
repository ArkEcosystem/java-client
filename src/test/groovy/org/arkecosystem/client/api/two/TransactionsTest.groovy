package org.arkecosystem.client.api.two

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class TransactionsTest extends Specification {
    def "all"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('transactions').all()
        then:
            actual.success == true
    }

    // def "create"() {
    //     setup:
    //         def connection = MockHelper.connection(2)
    //     when:
    //         def actual = connection.api('transactions').create()
    //     then:
    //         actual.success == true
    // }

    def "show"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('transactions').show("dummy")
        then:
            actual.success == true
    }

    def "allUnconfirmed"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('transactions').allUnconfirmed()
        then:
            actual.success == true
    }

    def "showUnconfirmed"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('transactions').showUnconfirmed("dummy")
        then:
            actual.success == true
    }

    def "search"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('transactions').search()
        then:
            actual.success == true
    }

    def "types"() {
        setup:
            def connection = MockHelper.connection(2)
        when:
            def actual = connection.api('transactions').types()
        then:
            actual.success == true
    }
}
