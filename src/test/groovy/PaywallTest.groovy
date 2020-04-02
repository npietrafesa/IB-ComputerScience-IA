import geb.spock.GebSpec
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import spock.lang.Ignore
import spock.lang.Stepwise
import spock.lang.Unroll

@Stepwise
class PaywallTest extends GebSpec {

    void setupSpec() {
        driver.manage().window().setSize(new Dimension(1920, 1233))
    }

    def "Is on Paywall Page"() {
        when:
        to ShoPaywallPage

        then:
        at ShoPaywallPage
        assert $("div.modal")
        $("div.modal button.close").click()
    }

    @Unroll
    def "Ensure that #pageW page of 'see whats on' section loads"() {
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
    def "See that #devX page of 'ways to watch' works"() {
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

    def "See that 'whats included' page works"() {
        setup:
        waitFor { $("#nav-included") }.click()

        when:
        $("#fd-whats-included div.footer-links span.learn-more a").click()
        sleep(1000)

        then:
        waitFor { $("#fd-whats-included table thead tr.desktop th.stat img") }
        $("span.stat-link")

        and:
        waitFor { !$("#fd-whats-included div.footer-links span.learn-more a").displayed }

        when:
        $("#fd-whats-included table tbody tr:nth-child(3) td:nth-child(1) p a").click()
        sleep(3000)

        then:
        at ShoSupportedDevicesPage

        when:
        withWindow({ ShoSupportedDevicesPage }) { close() }

        then:
        at ShoPaywallPage

    }

}
