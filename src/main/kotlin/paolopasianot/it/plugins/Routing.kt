package paolopasianot.it.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import paolopasianot.it.html.index
import paolopasianot.it.html.model.IndexPages
import paolopasianot.it.html.model.SupportedLangs
import paolopasianot.it.html.model.Theme
import paolopasianot.it.html.model.WebsiteCoreData
import paolopasianot.it.html.webPage
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

        webPage()

        staticResources("/static", "static")

        route("api/v1"){
            restApi()
        }

        route("service/v1"){
            service()
        }

        login()
        //embedded()
    }
}
