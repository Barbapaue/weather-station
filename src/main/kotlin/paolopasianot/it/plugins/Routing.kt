package paolopasianot.it.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import paolopasianot.it.html.index
import paolopasianot.it.routing.api.login
import paolopasianot.it.routing.restApi
import paolopasianot.it.routing.embedded
import paolopasianot.it.routing.service.service

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {

        get("/") {
            call.respondHtml {
                index()
            }
        }

        staticResources("/static", "static")

        route("api/v1"){
            restApi()
        }

        route("service/v1"){
            service()
        }

        login()
        embedded()
    }
}
