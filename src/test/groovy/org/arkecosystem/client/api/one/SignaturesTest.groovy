package org.arkecosystem.client.api.one

import spock.lang.Specification
import org.arkecosystem.client.MockHelper

class SignaturesTest extends Specification {
    def "fee"() {
        setup:
            def connection = MockHelper.connection()
        when:
            def actual = connection.api('signatures').fee()
        then:
            actual.success == true
    }
}
