import geb.Page

class ShoPaywall extends Page {
    static at = { waitFor { $("a.signin") } }
}
