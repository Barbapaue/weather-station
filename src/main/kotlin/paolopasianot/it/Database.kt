package paolopasianot.it

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.*
import paolopasianot.it.plugins.ExposedUser
import paolopasianot.it.plugins.UserService

object DB {

    fun init(){
        Database.connect(startHikari())
    }

    private fun startHikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.ds.PGSimpleDataSource"
        config.jdbcUrl = "jdbc:postgresql://ep-small-shape-a2e217fk.eu-central-1.aws.neon.tech/weatherstation?sslmode=require"
        config.username = "paolo.pasianot@icloud.com"
        config.password = "HE7cTwFCAJ2x"
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }
}

fun Application.configureDatabases() {
    val database = Database.connect(
        url = "postgresql://paolo.pasianot%40icloud.com:************@ep-small-shape-a2e217fk.eu-central-1.aws.neon.tech/weatherstation?sslmode=require",
        user = "root",
        driver = "org.h2.Driver",
        password = ""
    )
    val userService = UserService(database)
    routing {
        // Create user
        post("/users") {
            val user = call.receive<ExposedUser>()
            val id = userService.create(user)
            call.respond(HttpStatusCode.Created, id)
        }
        // Read user
        get("/users/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
            val user = userService.read(id)
            if (user != null) {
                call.respond(HttpStatusCode.OK, user)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }
        // Update user
        put("/users/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
            val user = call.receive<ExposedUser>()
            userService.update(id, user)
            call.respond(HttpStatusCode.OK)
        }
        // Delete user
        delete("/users/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
            userService.delete(id)
            call.respond(HttpStatusCode.OK)
        }
    }
}
