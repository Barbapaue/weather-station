package paolopasianot.it.routing.service

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import paolopasianot.it.auth.ApplicationUsers
import paolopasianot.it.model.Client
import paolopasianot.it.storage.ClientService

fun Route.service() {
    authenticate(ApplicationUsers.ROOT.auth) {
        route("/client") {
            get {
                val clients = ClientService.getAll()
                call.respond<List<Client>>(HttpStatusCode.OK, clients)
            }
            post {
                val formParameters = call.receiveParameters()
                val name = formParameters["name"].toString()
                val nome = formParameters["note"]
                ClientService.create(name, nome)
                call.respondRedirect("/", permanent = true)
            }
            put("{clientID}") {

            }
        }
    }
}