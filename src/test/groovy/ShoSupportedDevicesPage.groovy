import geb.Page

class ShoSupportedDevicesPage extends Page {

    static at = { waitFor { $("body header div.header-inner div a img") } }

}