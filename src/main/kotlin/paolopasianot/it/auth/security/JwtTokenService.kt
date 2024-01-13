package paolopasianot.it.auth.security

import com.auth0.jwt.JWT

class JwtTokenService: TokenService {
    override fun generate(config: TokenConfig, vararg claim: TokenClaim) {
        //return JWT.decode()
    }
}