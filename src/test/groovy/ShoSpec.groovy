import geb.spock.GebSpec
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point




class ShoSpec extends GebSpec {
void setupSpec(){
    driver.manage().window().setSize(new Dimension(1920, 1233))
//    driver.manage().window().setPosition(new Point(22, 22))
}
    def "Starting on homepage"() {
        when:
            to ShoPaywall

        then:
            at ShoPaywall

    }
}
