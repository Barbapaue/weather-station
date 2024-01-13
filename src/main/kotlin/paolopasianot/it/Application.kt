package paolopasianot.it

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import paolopasianot.it.DB.db
import paolopasianot.it.plugins.*
import paolopasianot.it.storage.ClientService

fun main() {
    TransactionManager.defaultDatabase = db
    embeddedServer(Netty, module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureAuthentication()
    configureSerialization()
    configureWebjars()

    configureMqtt()
    configureRouting()

}
