package paolopasianot.it

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import paolopasianot.it.plugins.*

fun main() {
    embeddedServer(Netty, module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureMqtt()
    //configureSerialization()
    configureDatabases()
    configureRouting()
}
