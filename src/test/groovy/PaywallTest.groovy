import geb.spock.GebSpec
import org.openqa.selenium.Dimension
import spock.lang.Ignore
import spock.lang.Stepwise
import spock.lang.Unroll

@Stepwise
class PaywallTest extends GebSpec {

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

    @Unroll
    def "Ensure that #pageW section of 'see whats on' page works"() {
        setup:
        waitFor { $("#nav-whatson") }.click()
        sleep(1000)

        when:
        $("#fd-whats-on > div:nth-child(2) > div > div:nth-child($numW) > div > div.content > a.cta").click()
        sleep(1000)

        then:
        $("div.content-header h1.title.desktop").text().contains(pageW)

        when:
        $("span.close").click()

        then:
        !$("div.content-header h1.title.desktop")


        where:
        numW || pageW
        1    || "SERIES"
        2    || "MOVIES"
        3    || "SPORTS"
        4    || "LIVE"
        5    || "FREE"
    }

    @Unroll
    def "Ensure that #devX section of 'ways to watch' page works"() {
        setup:
        waitFor { $("#nav-where").click() }

        when:
        $("#devices-$devX div.clickable span span.cta-label").click()
        sleep(1000)

        then:
        $("#devices-$devX div.device-list h1").text().contains(pageX)

        when:
        $("#devices-$devX div.device-list a.close").click()

        then:
        !$("#devices$devX > div.device-list")

        where:
        numX | devX        || pageX
        2    | "tv"        || "TV with"
        3    | "mobile"    || "VR with"
        4    | "computers" || "on your"
    }

    def "Ensure 'whats included' page works"() {
        setup:
        waitFor { $("#nav-included") }.click()

        when:
        sleep(1000)
        $("#fd-whats-included div.footer-links span.learn-more a").click()
        sleep(1000)

        then:
        waitFor { $("#fd-whats-included table thead tr.desktop th.stat img") }
        $("span.stat-link")

        and:
        waitFor { !$("#fd-whats-included div.footer-links span.learn-more a").displayed }

        when:
        $("#fd-whats-included table tbody tr:nth-child(3) td:nth-child(1) p a").click()
        sleep(2000)

        then:
        withWindow({ title == "What devices can I use to watch the SHOWTIME streaming service? – HELP CENTER" }, close: true) {
            at ShoSupportedDevicesPage
        }

        expect:
        at ShoPaywallPage

    }

    def "Ensure that 'ways to buy' page works"() {
        sleep(1000)
        when:
        waitFor { $("#page-paywall-frontdoor div.frontdoor-content-wrapper div:nth-child(1) div div:nth-child(1) ul li.hide-mobile a").click() }
        sleep(2000)

        then:
        withWindow({ title == "Order SHOWTIME Now" }, close: true) {
            at ShoBuyPage
        }

        expect:
        at ShoPaywallPage

    }

    def "Go to login page"() {
        when:
        js.exec(0, -100, "window.scroll(arguments[0], arguments[1])")

        and:
        waitFor { $("a.signin").click() }

        then:
        at ShoLoginPage
    }
}
