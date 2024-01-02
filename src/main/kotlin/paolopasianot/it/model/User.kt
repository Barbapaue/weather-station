package paolopasianot.it.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val clientID: Int,
    val name: String,
    val password: String,
    val note: String? = null
)
