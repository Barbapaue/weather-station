package paolopasianot.it.routing

import io.ktor.server.routing.*
import paolopasianot.it.routing.api.clientApi
import paolopasianot.it.routing.api.login

fun Route.restApi(){
    clientApi()
    login()
}