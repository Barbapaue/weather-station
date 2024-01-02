package paolopasianot.it.auth

import io.ktor.util.*

val digestFunction = getDigestFunction("SHA-256") { "weather-station-${it.length}" }