import geb.Module

class LoginModule extends Module {


    static content = {
        form { waitFor { $("form") } }
        button { $("form button") }
    }

    void logIntoSite() {
        form.with {
            email = "IBCompSci@testing.showtime.net"
            password = "ibcompsci1"
            button().click()
        }
    }
}
