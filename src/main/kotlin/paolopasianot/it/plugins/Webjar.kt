package paolopasianot.it.plugins

import io.ktor.server.application.*
import io.ktor.server.webjars.*

fun Application.configureWebjars(){
    install(Webjars){
        path = "assets"
    }
}