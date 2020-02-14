package com.ibo.compsci.groovy

import geb.spock.GebSpec

class test extends GebSpec{

    def "can go to google"() {
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
