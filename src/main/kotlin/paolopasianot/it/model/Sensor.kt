package paolopasianot.it.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sensor(
    val id: Int,
    @SerialName("station_id")
    val stationID: Int,
    val name: String
)
