import geb.spock.GebSpec
import org.openqa.selenium.Dimension
import spock.lang.Stepwise

@Stepwise
class MovieTest extends GebSpec {

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

    def "Select Random Movie"() {
        setup:
        def rand = new Random().nextInt(8 - 2) + 2

        to ShoMoviesPage
        at ShoMoviesPage

        when:
        waitFor { $("li.movie", rand).find(".play-lg") }.click()

        then:
        waitFor { $("video#player-video").hasClass("js-player-video") }

        when:
        $("#player-video-overlay button.player-close-button").click()

        then:
        !$("video#player-video").hasClass("js-player-video")

    }

}
