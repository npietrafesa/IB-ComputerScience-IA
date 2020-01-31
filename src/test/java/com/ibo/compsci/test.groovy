package com.ibo.compsci
import geb.Page
import geb.spock.GebSpec
class test {
    def "login to admin section"() {
        given:
        to LoginPage

        when:
        loginForm.with {
            username = "admin"
            password = "password"
        }

        and:
        loginButton.click()

        then:
        at AdminPage
    }
}
