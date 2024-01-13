package paolopasianot.it.auth.security

data class TokenConfig(
    val issuer: String,
    val audience: String,
    val expiresIn: String,
    val secret: String
)