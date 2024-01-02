package paolopasianot.it.model

import kotlinx.serialization.SerialName

data class SensorData(
    val id: Int,
    @SerialName("sensor_id")
    val sensorID: Int,
    val data: String,
    val note: String? = null
)
