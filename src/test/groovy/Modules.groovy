import geb.Module

class Modules extends Module {
}

class LoginModule extends Module {


    static content = {
        form { waitFor { $("form") } }
        button { $("form button") }
    }

    void logIntoSite() {
        User user = new User()
        form.with {
            email = user.getEmail()
            password = user.getPassword()
            button().click()
        }
    }
}
