import geb.spock.GebSpec
import org.openqa.selenium.Dimension

class SigninTest extends GebSpec {

    void setupSpec() {
        driver.manage().window().setSize(new Dimension(1920, 1233))
    }

    def "Ensure that on Paywall Page"() {
        when:
        to ShoPaywallPage

        then:
        at ShoPaywallPage
        assert $("div.modal")
        $("div.modal button.close").click()
    }

    def "Go to login page"() {
        when:
        js.exec(0, -100, "window.scroll(arguments[0], arguments[1])")

        and:
        waitFor { $("a.signin").click() }

        then:
        at ShoLoginPage
    }

    def "Login to site"() {
        when:
        at ShoLoginPage

        and:
        login.logIntoSite()

        then:
        at ShoHomePage

    }

}
