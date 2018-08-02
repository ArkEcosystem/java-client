package org.arkecosystem.client.api.one

import spock.lang.Specification
import org.arkecosystem.client.Connection

class TransactionsTest extends Specification {
    def "all"() {
        setup:
            def connection = new Connection('https://explorer.ark.io:8443/api/')
        when:
            def actual = connection.api('transactions').all()
        then:
            actual.success == true
    }
}
