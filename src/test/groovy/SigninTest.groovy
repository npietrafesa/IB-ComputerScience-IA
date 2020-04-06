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
         $("div.modal")
        $("div.modal button.close").click()
    }

    def "Go to login page"() {
        when:
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

    def "Logout of site"() {
        when:
        $("#account-menu a").jquery.mouseover()

        then:
        $("#account-menu div").displayed

        sleep(1000)

        when:
        $("#account-menu div ul li:nth-child(9) a").click()

        then:
        at ShoPaywallPage
    }

}
