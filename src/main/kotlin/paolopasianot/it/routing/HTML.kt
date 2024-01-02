package paolopasianot.it.routing

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import paolopasianot.it.auth.ApplicationUsers
import paolopasianot.it.html.ClientPage
import paolopasianot.it.html.IndexPage
import paolopasianot.it.html.WeatherStationUI

fun Routing.html(){
    authenticate(ApplicationUsers.ROOT.auth) {
        get("/") {
            call.respondHtmlTemplate(IndexPage(
                listOf(
                    WeatherStationUI(name = "Stazione1", description = "Prova1"),
                    WeatherStationUI(name = "Stazione2", description = "Prova2")
                )
            )) {
                ulNavigationItems{
                    ul{
                        li{
                            a(href = "client") {
                                title = "Pagina per l'aggiunta di nuovi clienti"
                                +"Add new Client"

                            }
                            a(href = "#") {
                                +"list item 1"
                            }
                        }
                    }
                }
            }
        }
        get("/client"){
            call.respondHtmlTemplate(ClientPage()){

            }
        }
    }

    get("/test") {
        call.respondText("Hello World!")
    }
}