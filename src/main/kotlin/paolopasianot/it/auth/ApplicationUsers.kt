package paolopasianot.it.auth

enum class ApplicationUsers(
    val auth: String
) {
    ROOT("auth-root"), USER("auth-basic")
}