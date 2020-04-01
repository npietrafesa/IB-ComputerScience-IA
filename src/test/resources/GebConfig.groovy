import org.openqa.selenium.os.ExecutableFinder
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeDriverService

import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS

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

waiting {
    timeout = 30
    retryInterval = 0.1
    includeCauseInMessage = true
}
atCheckWaiting = true

baseUrl = "https://www.qa2.showtime.com"