import geb.Page

class Pages extends Page {

}

class ShoPaywallPage extends Page {

    static url = "/#getstarted"
    static at = { waitFor { $("a.signin") } }

}

class ShoSupportedDevicesPage extends Page {

    static at = { waitFor { $("body header div.header-inner div a img") } }

}

class ShoBuyPage extends Page {
    static at = { waitFor { $("body div.site-container div section.hero.hero--no-accent.hero--video.hero--order.js-hero-video section.order-tray.order-tray--redux.order-tray--chameleon.js-order-tray-redux div nav h3") } }
}

class ShoLoginPage extends Page {
    static at = { waitFor { $("#email") } }
    static content = {
        login { module(LoginModule) }
    }
}

class ShoHomePage extends Page {
    static at = { waitFor { $("#account-menu > a > img").displayed } }
}

