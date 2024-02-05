package paolopasianot.it.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import paolopasianot.it.auth.ApplicationUsers

fun Application.configureAuthentication(){
    install(Authentication) {
        basic(ApplicationUsers.ROOT.auth) {
           realm = "Private section"
            validate { credentials ->
                if (credentials.name == "MyWeatherWhatTheFuck" && credentials.password == "catxuk-wAcgan-tujgo3") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
        basic(ApplicationUsers.USER.auth) {
            realm = "Access for users"
            validate { credentials ->
                if (credentials.name == "jetbrains" && credentials.password == "foobar") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
}