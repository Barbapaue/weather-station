package paolopasianot.it.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Station(
    val id: Int,
    @SerialName("client_id")
    val clientID: Int,
    val name: String,
    val note: String? = null,
    val updateRequired: Boolean
)
