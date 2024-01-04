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

    val db by lazy {
        Database.connect(
            url = "jdbc:pgsql://ep-small-shape-a2e217fk.eu-central-1.aws.neon.tech/weatherstation?sslmode=require",
            driver = "org.postgresql.ds.PGSimpleDataSource",
            user = "paolo.pasianot@icloud.com",
            password = "HE7cTwFCAJ2x"
        )
    }

    //Stand-by
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

