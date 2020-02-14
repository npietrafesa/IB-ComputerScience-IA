package com.ibo.compsci.groovy

import geb.Page

class GebishOrgHomePage extends Page{

    static at = { title == "Geb - Very Groovy Browser Automation" }

    static content = {
        manualsMenu { module(ManualsMenuModule) }
    }

}
