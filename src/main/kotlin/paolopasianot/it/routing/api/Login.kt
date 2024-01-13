package paolopasianot.it.routing.api

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val adminCredential = mapOf(
    "Paolo Pasianot" to "5htt84Prg#qEV1!Db8!A",
    "Carlo Falcomer" to "pNws@Wp^a&6RvL5PPsY6",
    "Paolo Bazzanella" to "88E4Nux@b2yWNe3TdQKr",
    "Cecilia Bartolini" to "^vCdzpdgC8JUnHtyNNUw"
)

fun Route.login(){
    post("login") {
        try {
            val formParameters = call.receiveParameters()
            val username = formParameters["username"].toString()
            val password = formParameters["password"].toString()

            adminCredential[username]?.let { adminPsw ->
                if(adminPsw == password){
                    call.respond(HttpStatusCode.OK)
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            } ?: call.respond(HttpStatusCode.BadRequest)
        } catch (e: Exception) {
            e.printStackTrace()
            call.respond(HttpStatusCode.BadRequest, message = "Errore interno al server")
        }
    }
}