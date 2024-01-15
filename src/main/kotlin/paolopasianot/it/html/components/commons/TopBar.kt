package paolopasianot.it.html.components.commons

import kotlinx.html.*

fun DIV.topBar(){
    nav(classes = "navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow") {

        ul(classes = "navbar-nav ml-auto") {
            li(classes = "nav-item dropdown no-arrow mx-1"){
                a(classes = "nav-link dropdown-toggle", href = "#"){
                    role = "button"
                    id = "messagesDropdown"
                    attributes["data-toggle"] = "dropdown"
                    attributes["aria-haspopup"] = "true"
                    attributes["aria-expanded"] = "false"

                    i(classes = "fas fa-envelope fa-fw")
                    span(classes = "badge badge-danger badge-counter") { +"7" }
                }

                div(classes = "dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"){
                    attributes["aria-labelledby"] = "messagesDropdown"
                    h6(classes = "dropdown-header") { +"Message Center" }

                    listOf(
                        MessageData(
                            img = "static/img/undraw_profile_1.svg",
                            message = "Buongiorno! ho avuto un problema, riusciamo a sentirci?",
                            owner = "Roberto Pasianot"
                        ),
                        MessageData(
                            img = "static/img/undraw_profile_2.svg",
                            message = "Quando arriva sta stazione meteo!!!",
                            owner = "Diego Pasianot"
                        ),
                       /* MessageData(
                            img = "static/img/undraw_profile_3.svg",
                            message = "Buongiorno! ho avuto un problema, riusciamo a sentirci?",
                            owner = ""
                        )*/
                    ).map {
                        a(classes = "dropdown-item d-flex align-items-center", href = "#"){
                            div(classes = "dropdown-list-image mr-3") {
                                img(classes = "rounded-circle", src = it.img, alt = "...")
                                div(classes = "status-indicator bg-success")
                            }
                            div(classes = "font-weight-bold"){
                                div(classes = "text-truncate"){ + it.message }
                                div(classes = "small text-gray-500"){ + it.owner }
                            }
                        }
                    }

                }
            }
        }
    }
}

private data class MessageData(
    val img: String,
    val message: String,
    val owner: String
)