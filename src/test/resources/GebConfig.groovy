import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.os.ExecutableFinder

//import org.openqa.selenium.edge.EdgeDriver
//import org.openqa.selenium.edge.EdgeDriverService

import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS

File findDriver() {
    def executable = new ExecutableFinder().find("chromedriver")
    if (executable) {
        new File(executable)
    }
}

driver = {
//    EdgeDriverService.Builder builder = new EdgeDriverService.Builder()
    ChromeDriverService.Builder builder = new ChromeDriverService.Builder()
            .usingAnyFreePort()
            .usingDriverExecutable(findDriver())
    new ChromeDriver(builder.build())
//    new EdgeDriver(builder.build())
}

waiting {
    timeout = 30
    retryInterval = 0.1
    includeCauseInMessage = true
}
atCheckWaiting = true

baseUrl = "https://www.qa2.showtime.com"