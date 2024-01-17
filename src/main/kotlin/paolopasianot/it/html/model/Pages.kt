package paolopasianot.it.html.model

enum class IndexPages(
    val title: String,
    val icon: String,
    val href: String
){
    HOME(title = "Home", icon = "home", href = "/home"),
    DATABASE(title = "Database", icon = "database", href = "/database")
}
