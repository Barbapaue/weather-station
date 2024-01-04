package paolopasianot.it.routing.api

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import paolopasianot.it.model.Client
import paolopasianot.it.model.User
import paolopasianot.it.storage.ClientService
import paolopasianot.it.storage.UserService

fun Route.userApi(clientID: Int = 1) {
    route("user") {
        get {
            val users = UserService.getAllByClientID(clientID)
            call.respond<List<User>>(HttpStatusCode.OK, users)
        }

        post {
            try {
                val formParameters = call.receiveParameters()
                val name = formParameters["name"].toString()
                val password = formParameters["password"].toString()
                val note = formParameters["note"]
                UserService.create(clientID, name, password, note)
                call.respond(HttpStatusCode.OK)
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.BadRequest, message = "Errore interno al server")
            }
        }

        put {
            try {
                val user = call.receive<User>()
                UserService.update(user)
                call.respond(HttpStatusCode.OK)
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        delete("/all") {
            try {
                UserService.deleteClientID(clientID)
                call.respond(HttpStatusCode.OK)
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        route("{userID}") {
            get {
                val id = call.request.queryParameters["userID"]?.toIntOrNull()
                if (id != null) {
                    try {
                        val user = UserService.read(id) ?: throw Exception("ID non valido per i user: $id")
                        call.respond(HttpStatusCode.OK, user)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        call.respond(HttpStatusCode.BadRequest)
                    }
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
            put {
                val id = call.request.queryParameters["userID"]?.toIntOrNull()
                if (id != null) {
                    val formParameters = call.receiveParameters()
                    val name = formParameters["name"].toString()
                    val password = formParameters["password"].toString()
                    val note = formParameters["note"]
                    UserService.update(id, clientID, name, password, note)
                    call.respond(HttpStatusCode.OK)
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
            delete {
                val id = call.request.queryParameters["userID"]?.toIntOrNull()
                if (id != null) {
                    try {
                        UserService.delete(id)
                        call.respond(HttpStatusCode.OK)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        call.respond(HttpStatusCode.BadRequest)
                    }
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }
    }
}