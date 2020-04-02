import geb.Module

class ManualsMenuModule extends Module {
    static content = {
        toggle(wait: true) { $("div.menu a.manuals") }
        linksContainer { $("#manuals-menu") }
        links { linksContainer.find("a") }
    }

    void open() {
        toggle.click()
        waitFor { !linksContainer.hasClass("animating") }
    }
}
