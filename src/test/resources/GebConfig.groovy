import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.os.ExecutableFinder



File findDriver() {
    def executable = new ExecutableFinder().find("chromedriver")
    if (executable) {
        new File(executable)
    }
}

driver = {
    ChromeDriverService.Builder builder = new ChromeDriverService.Builder()
            .usingAnyFreePort()
            .usingDriverExecutable(findDriver())
    new ChromeDriver(builder.build())
}

waiting {
    timeout = 30
    retryInterval = 0.1
    includeCauseInMessage = true
}
atCheckWaiting = true

baseUrl = "https://www.qa2.showtime.com"