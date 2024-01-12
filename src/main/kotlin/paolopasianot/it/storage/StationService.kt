package paolopasianot.it.storage

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import paolopasianot.it.model.Station
import paolopasianot.it.utilities.dbQuery

object StationService {

    object StationTable : Table() {
        val id = integer("id").autoIncrement()
        val clientID = integer("client_id")
        val name = varchar("name", length = 255)
        val note = varchar("note", length = 255).nullable()
        val updateRequired = bool("update_required").default(false)

        override val primaryKey = PrimaryKey(id)
    }

    suspend fun create(clientID: Int, name: String, updateRequired: Boolean, note: String? = null): Int = dbQuery {
        StationTable.insert {
            it[this.clientID] = clientID
            it[this.updateRequired] = updateRequired
            it[this.name] = name
            it[this.note] = note
        }[StationTable.id]
    }

    suspend fun getAll(): List<Station> {
        return dbQuery {
            StationTable.selectAll()
                .map {
                    Station(
                        id = it[StationTable.id],
                        clientID = it[StationTable.clientID],
                        name = it[StationTable.name],
                        note = it[StationTable.note],
                        updateRequired = it[StationTable.updateRequired]
                    )
                }
        }
    }

    suspend fun getAllByClientID(clientID: Int): List<Station> {
        return dbQuery {
            StationTable.selectAll()
                .andWhere { StationTable.id eq clientID }
                .map {
                    Station(
                        id = it[StationTable.id],
                        clientID = it[StationTable.clientID],
                        name = it[StationTable.name],
                        note = it[StationTable.note],
                        updateRequired = it[StationTable.updateRequired]
                    )
                }
        }
    }

    suspend fun read(id: Int): Station? {
        return dbQuery {
            StationTable.selectAll()
                .andWhere { StationTable.id eq id }
                .map {
                    Station(
                        id = it[StationTable.id],
                        clientID = it[StationTable.clientID],
                        name = it[StationTable.name],
                        updateRequired = it[StationTable.updateRequired],
                        note = it[StationTable.note]
                    )
                }
                .singleOrNull()
        }
    }

    suspend fun update(station: Station) {
        dbQuery {
            StationTable.update({ StationTable.id eq station.id }) {
                it[this.clientID] = station.clientID
                it[this.updateRequired] = station.updateRequired
                it[this.name] = station.name
                it[this.note] = station.note
            }
        }
    }

    suspend fun update(id: Int, clientID: Int, name: String, updateRequired: Boolean, note: String? = null) {
        dbQuery {
            StationTable.update({ StationTable.id eq id }) {
                it[this.clientID] = clientID
                it[this.updateRequired] = updateRequired
                it[this.name] = name
                it[this.note] = note
            }
        }
    }

    suspend fun delete(id: Int) {
        dbQuery {
            StationTable.deleteWhere { StationTable.id.eq(id) }
        }
    }

    suspend fun deleteClientID(clientID: Int) {
        dbQuery {
            StationTable.deleteWhere { StationTable.clientID.eq(clientID) }
        }
    }

}