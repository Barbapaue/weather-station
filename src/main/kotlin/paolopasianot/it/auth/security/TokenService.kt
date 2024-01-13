package paolopasianot.it.auth.security

interface TokenService {
    fun generate(
        config: TokenConfig,
        vararg claim: TokenClaim
    )
}