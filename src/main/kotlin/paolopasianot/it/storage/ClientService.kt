package paolopasianot.it.storage

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import paolopasianot.it.model.Client
import paolopasianot.it.model.response.ClientInvitationalCode
import paolopasianot.it.utilities.dbQuery
import kotlin.random.Random

object ClientService {

    object ClientTable : Table() {
        val id = integer("id").autoIncrement()
        val name = varchar("name", length = 255)
        val invitationCode = varchar("invitation_code", length = 255)
        val note = varchar("note", length = 255).nullable()

        override val primaryKey = PrimaryKey(id)
    }

    fun generateInvitationCode(): String {
        val rand = listOf(('0'..'9'), ('a'..'z'), ('A'..'Z')).flatten()
        return (0 .. 19).map {
            rand.random()
        }.joinToString(separator = "")
    }

    suspend fun create(name: String, note: String? = null, invitationCode: String = generateInvitationCode()): Int = dbQuery {
        ClientTable.insert {
            it[this.name] = name
            it[this.invitationCode] = invitationCode
            it[this.note] = note
        }[ClientTable.id]
    }

    /***
     * Se la lista risultante è vuota vuol dire che non esistono chienti con quel codice invito
     *
     * @param invitationCode [String] codice di invito
     */
    suspend fun invitationalCodeExist(invitationCode: String): List<ClientInvitationalCode> = dbQuery {
        //miglioria prendere il "singleOrNull" perchè dovrebbe essere unico ma per ora lasciamo cosi
        ClientTable.selectAll().andWhere {
            ClientTable.invitationCode eq invitationCode
        }.map {
            ClientInvitationalCode(
                id = it[ClientTable.id],
                name = it[ClientTable.name]
            )
        }
    }

    suspend fun getAll(): List<Client> {
        return dbQuery {
            ClientTable.selectAll()
                .map {
                    Client(
                        id = it[ClientTable.id],
                        name = it[ClientTable.name],
                        invitationCode = it[ClientTable.invitationCode],
                        note = it[ClientTable.note]
                    )
                }
        }
    }

    suspend fun read(id: Int): Client? {
        return dbQuery {
            ClientTable.selectAll()
                .andWhere { ClientTable.id eq id }
                .map {
                    Client(
                        id = it[ClientTable.id],
                        name = it[ClientTable.name],
                        invitationCode = it[ClientTable.invitationCode],
                        note = it[ClientTable.note]
                    )
                }
                .singleOrNull()
        }
    }

    suspend fun update(client: Client) {
        dbQuery {
            ClientTable.update({ ClientTable.id eq client.id }) {
                it[name] = client.name
                it[note] = client.note
            }
        }
    }

    suspend fun update(id: Int, name: String, note: String? = null) {
        dbQuery {
            ClientTable.update({ ClientTable.id eq id }) {
                it[this.name] = name
                it[this.note] = note
            }
        }
    }

    suspend fun delete(id: Int) {
        dbQuery {
            ClientTable.deleteWhere { ClientTable.id.eq(id) }
        }
    }

}