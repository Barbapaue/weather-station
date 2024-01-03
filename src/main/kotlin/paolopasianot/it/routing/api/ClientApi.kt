package paolopasianot.it.routing.api

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import paolopasianot.it.storage.ClientService

fun Route.clientApi() {
    route("/client") {
        get {
            val text = call.receiveText()
            call.respondText(text)
        }
        post {
            val formParameters = call.receiveParameters()
            val name = formParameters["name"].toString()
            val nome = formParameters["note"]
            ClientService.create(name, nome)
            call.respondRedirect("/", permanent = true)
        }
        put {
            val text = call.receiveText()
            call.respondText(text)
        }
    }
}