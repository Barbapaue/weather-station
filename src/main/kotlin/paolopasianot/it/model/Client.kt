package paolopasianot.it.model

import kotlinx.serialization.Serializable

@Serializable
data class Client(
    val id: Int,
    val name: String,
    val note: String? = null
)
