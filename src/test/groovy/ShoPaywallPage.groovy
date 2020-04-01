import geb.Page

class ShoPaywallPage extends Page {

    static url = "/#getstarted"
    static at = { waitFor { $("a.signin") } }

}
