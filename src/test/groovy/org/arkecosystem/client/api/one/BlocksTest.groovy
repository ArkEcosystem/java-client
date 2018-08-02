package org.arkecosystem.client.api.one

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class BlocksTest extends Specification {
    def "all"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').all()
        then:
            actual.success == true
    }

    def "show"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').show("dummy")
        then:
            actual.success == true
    }

    def "epoch"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').epoch()
        then:
            actual.success == true
    }

    def "fee"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').fee()
        then:
            actual.success == true
    }

    def "fees"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').fees()
        then:
            actual.success == true
    }

    def "height"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').height()
        then:
            actual.success == true
    }

    def "milestone"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').milestone()
        then:
            actual.success == true
    }

    def "nethash"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').nethash()
        then:
            actual.success == true
    }

    def "reward"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').reward()
        then:
            actual.success == true
    }

    def "status"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').status()
        then:
            actual.success == true
    }

    def "supply"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('blocks').supply()
        then:
            actual.success == true
    }
}
