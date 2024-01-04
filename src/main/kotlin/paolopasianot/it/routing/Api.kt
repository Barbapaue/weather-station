package paolopasianot.it.routing

import io.ktor.server.auth.*
import io.ktor.server.routing.*
import paolopasianot.it.auth.ApplicationUsers
import paolopasianot.it.routing.api.clientApi

fun Route.restApi(){
    authenticate(ApplicationUsers.ROOT.auth) {
        clientApi()
    }
}