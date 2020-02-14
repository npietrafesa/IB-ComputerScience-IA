package com.ibo.compsci.resources

import org.openqa.selenium.edge.EdgeDriver

    environments {
        edge {
            System.setProperty("webdriver.edge.driver", "C:/Users/thepi/IdeaProjects/IAtest/msedgedriver.exe")
            driver = {new EdgeDriver()}
        }
    }

    baseUrl = "http://gebish.org"