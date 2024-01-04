package paolopasianot.it.storage

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import paolopasianot.it.model.User
import paolopasianot.it.utilities.dbQuery

object UserService {

    object UserTable : Table() {
        val id = integer("id").autoIncrement()
        val clientID = integer("client_id")
        val name = varchar("name", length = 255)
        val password = varchar("password", length = 255)
        val note = varchar("note", length = 255).nullable()

        override val primaryKey = PrimaryKey(id)
    }

    suspend fun create(clientID: Int, name: String, password: String, note: String? = null): Int = dbQuery {
        UserTable.insert {
            it[this.clientID] = clientID
            it[this.password] = password
            it[this.name] = name
            it[this.note] = note
        }[UserTable.id]
    }

    suspend fun getAll(): List<User> {
        return dbQuery {
            UserTable.selectAll()
                .map {
                    User(
                        id = it[UserTable.id],
                        clientID = it[UserTable.clientID],
                        name = it[UserTable.name],
                        note = it[UserTable.note],
                        password = it[UserTable.password]
                    )
                }
        }
    }

    suspend fun getAllByClientID(clientID: Int): List<User> {
        return dbQuery {
            UserTable.selectAll()
                .andWhere { UserTable.id eq clientID }
                .map {
                    User(
                        id = it[UserTable.id],
                        clientID = it[UserTable.clientID],
                        name = it[UserTable.name],
                        note = it[UserTable.note],
                        password = it[UserTable.password]
                    )
                }
        }
    }

    suspend fun read(id: Int): User? {
        return dbQuery {
            UserTable.selectAll()
                .andWhere { UserTable.id eq id }
                .map {
                    User(
                        id = it[UserTable.id],
                        clientID = it[UserTable.clientID],
                        name = it[UserTable.name],
                        password = it[UserTable.password],
                        note = it[UserTable.note]
                    )
                }
                .singleOrNull()
        }
    }

    suspend fun update(user: User) {
        dbQuery {
            UserTable.update({ UserTable.id eq user.id }) {
                it[this.clientID] = user.clientID
                it[this.password] = user.password
                it[this.name] = user.name
                it[this.note] = user.note
            }
        }
    }

    suspend fun update(id: Int, clientID: Int, name: String, password: String, note: String? = null) {
        dbQuery {
            UserTable.update({ UserTable.id eq id }) {
                it[this.clientID] = clientID
                it[this.password] = password
                it[this.name] = name
                it[this.note] = note
            }
        }
    }

    suspend fun delete(id: Int) {
        dbQuery {
            UserTable.deleteWhere { UserTable.id.eq(id) }
        }
    }

    suspend fun deleteClientID(clientID: Int) {
        dbQuery {
            UserTable.deleteWhere { UserTable.clientID.eq(clientID) }
        }
    }

}