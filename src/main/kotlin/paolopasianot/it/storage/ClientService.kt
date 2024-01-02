package paolopasianot.it.storage

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import paolopasianot.it.model.Client
import paolopasianot.it.utilities.dbQuery

object ClientService {

    object ClientTable : Table() {
        val id = integer("id").autoIncrement()
        val name = varchar("name", length = 255)
        val note = varchar("note", length = 255).nullable()

        override val primaryKey = PrimaryKey(id)
    }

    suspend fun create(name: String, note: String? = null): Int = dbQuery {
        ClientTable.insert {
            it[this.name] = name
            it[this.note] = note
        }[ClientTable.id]
    }

    suspend fun read(id: Int): Client? {
        return dbQuery {
            ClientTable.selectAll()
                .andWhere { ClientTable.id eq id }
                .map {
                    Client(
                        id = it[ClientTable.id],
                        name = it[ClientTable.name],
                        note = it[ClientTable.note]
                    ) }
                .singleOrNull()
        }
    }

    suspend fun update(id: Int, user: Client) {
        dbQuery {
            ClientTable.update({ ClientTable.id eq id }) {
                it[name] = user.name
                it[note] = user.note
            }
        }
    }

    suspend fun delete(id: Int) {
        dbQuery {
            ClientTable.deleteWhere { ClientTable.id.eq(id) }
        }
    }

}