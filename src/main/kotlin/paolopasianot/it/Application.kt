package paolopasianot.it

import io.ktor.server.application.*
import io.ktor.server.netty.*
import paolopasianot.it.plugins.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    DB.init()

    configureAuthentication()
    configureSerialization()
    configureWebjars()

    //configureMqtt()
    configureRouting()

}
