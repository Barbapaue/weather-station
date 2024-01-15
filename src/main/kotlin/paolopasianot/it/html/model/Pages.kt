package paolopasianot.it.html.model


enum class Pages(val title: String, val href: String) {
    HOME(title = "Home", href = ""),
    CLIENTS(title = "Clienti", href = ""),
    STATIONS(title = "Stazioni", href = "")
}

enum class DatabasePages(
    val title: String,
    val menuName: String,
    val href: String
){
    CLIENTS(title = "Clienti", menuName = "clienti", href = "/clients"),
    USERS(title = "Utenti", menuName = "utenti", href = "/users"),
    STATIONS(title = "Stazioni Meteo", menuName = "stazioni", href = "/stations")
}