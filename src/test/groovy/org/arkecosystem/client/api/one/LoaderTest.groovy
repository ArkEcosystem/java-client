package org.arkecosystem.client.api.one

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class LoaderTest extends Specification {
    def "status"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('loader').status()
        then:
            actual.success == true
    }

    def "sync"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('loader').sync()
        then:
            actual.success == true
    }

    def "autoconfigure"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('loader').autoconfigure()
        then:
            actual.success == true
    }
}
