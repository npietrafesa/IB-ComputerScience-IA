package com.ibo.compsci.groovy

import geb.spock.GebSpec

class GebishOrgSpec extends GebSpec {

    def "Is on gebish homepage"() {
        when:
        to GebishOrgHomePage

        and:
        manualsMenu.open()

        then:
        manualsMenu.links[0].text().startsWith("current")

        when:
        manualsMenu.links[0].click()

        then:
        at TheBookOfGebPage
    }

}
