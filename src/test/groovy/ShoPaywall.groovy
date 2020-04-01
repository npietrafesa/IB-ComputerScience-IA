import geb.Page

class ShoPaywall extends Page {

   static url = "/#getstarted"
    static at = { waitFor { $("a.signin") } }

}
