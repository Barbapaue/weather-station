package paolopasianot.it.routing.api

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.not
import paolopasianot.it.model.Client
import paolopasianot.it.storage.ClientService

fun Route.clientApi() {

    route("client") {
        get {
            val clients = ClientService.getAll()
            call.respond<List<Client>>(HttpStatusCode.OK, clients)
        }
        put {
            try  {
                val client = call.receive<Client>()
                ClientService.update(client)
                call.respond(HttpStatusCode.OK)
            }catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        post {
            try {
                val formParameters = call.receiveParameters()
                val name = formParameters["name"].toString()
                val note = formParameters["note"]
                ClientService.create(name, note)
                call.respond(HttpStatusCode.OK)
            }catch (e: Exception){
                e.printStackTrace()
                call.respond(HttpStatusCode.BadRequest, message = "Errore interno al server")
            }
        }
        route("{clientID}"){

           /* val clientID = call.request.queryParameters["clientID"]?.toIntOrNull()
            if (clientID != null) {
                userApi(clientID)
            }*/

            userApi()

            get {
                val id = call.request.queryParameters["clientID"]?.toIntOrNull()
                if (id != null) {
                    try {
                        val client = ClientService.read(id) ?: throw Exception("ID non valido per i clienti: $id")
                        call.respond(HttpStatusCode.OK, client)
                    }catch (e: Exception){
                        e.printStackTrace()
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            put {
                val id = call.request.queryParameters["clientID"]?.toIntOrNull()
                if (id != null) {
                    val formParameters = call.receiveParameters()
                    val name = formParameters["name"].toString()
                    val note = formParameters["note"]
                    ClientService.update(id, name, note)
                    call.respond(HttpStatusCode.OK)
                }else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            delete{
                val id = call.request.queryParameters["clientID"]?.toIntOrNull()
                if (id != null) {
                    try {
                        ClientService.delete(id)
                        call.respond(HttpStatusCode.OK)
                    }catch (e: Exception){
                        e.printStackTrace()
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }


    }
}