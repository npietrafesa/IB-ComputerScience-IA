import geb.Page

class Pages extends Page {
//this is just here so I can easily refer to all pages in one class
}

class ShoPaywallPage extends Page {

    static url = "/#getstarted"
    static at = { $("a.signin") }

}

class ShoSupportedDevicesPage extends Page {

    static at = { $("body header div.header-inner div a img") }

}

class ShoBuyPage extends Page {
    static at = { $("body div.site-container div section.hero.hero--no-accent.hero--video.hero--order.js-hero-video section.order-tray.order-tray--redux.order-tray--chameleon.js-order-tray-redux div nav h3") }
}

class ShoLoginPage extends Page {
    static at = { $("#email") }
    static content = {
        login { module(LoginModule) }
    }
}

class ShoHomePage extends Page {
    static at = { $("#account-menu > a > img").displayed }
}

class ShoMoviesPage extends Page {
    static url = "/#/movies/allmovies"
    static at = { $("span.genre").text().equalsIgnoreCase("All Movies") }
}

