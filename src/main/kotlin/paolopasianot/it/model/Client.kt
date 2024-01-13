package paolopasianot.it.model

import kotlinx.serialization.Serializable
import paolopasianot.it.storage.ClientService

@Serializable
data class Client(
    val id: Int,
    val name: String,
    val invitationCode: String = ClientService.generateInvitationCode(),
    val note: String? = null
)
