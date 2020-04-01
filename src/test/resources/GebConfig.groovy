import org.openqa.selenium.os.ExecutableFinder
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeDriverService

File findDriver() {
    def executable = new ExecutableFinder().find("msedgedriver")
    if (executable) {
        new File(executable)
    }
}

driver = {
    EdgeDriverService.Builder builder = new EdgeDriverService.Builder()
            .usingPort(42069)
            .usingDriverExecutable(findDriver())
    new EdgeDriver(builder.build())
}

baseUrl = "https://www.qa2.showtime.com"