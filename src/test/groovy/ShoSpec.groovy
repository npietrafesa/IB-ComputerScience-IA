import geb.spock.GebSpec

class ShoSpec extends GebSpec {
    def "Starting on homepage"() {
        when:
            at ShoPaywall

        then:
            at ShoPaywall

    }
}
