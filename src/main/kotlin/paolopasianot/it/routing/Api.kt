package paolopasianot.it.routing

import io.ktor.server.routing.*
import paolopasianot.it.routing.api.clientApi

fun Route.restApi(){
    clientApi()

}