package paolopasianot.it.routing

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.li
import kotlinx.html.ul
import paolopasianot.it.html.Index
import paolopasianot.it.html.WeatherStationUI

fun Routing.html(){
    get("/") {
        call.respondHtmlTemplate(Index(
            listOf(
                WeatherStationUI(name = "Stazione1", description = "Prova1"),
                WeatherStationUI(name = "Stazione2", description = "Prova2")
            )
        )) {
            ulNavigationItems{
                ul{
                    li{  +"list item 1"}
                }
            }
        }
    }
    get("/test") {
        call.respondText("Hello World!")
    }
}