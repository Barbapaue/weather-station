package paolopasianot.it.html

import io.ktor.server.html.*
import kotlinx.html.*

class ClientPage(

) : Template<HTML> {

    override fun HTML.apply() {
        head {
            title = "Weather Station Client"
            link(
                rel = "stylesheet",
                href = "https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
            )
            link(
                rel = "stylesheet",
                href = "https://use.fontawesome.com/releases/v5.4.1/css/all.css"
            ) {
                attributes["crossorigin"] = "anonymous"
                integrity = "sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
            }
            link {
                rel = "stylesheet"
                href = "/static/client.css"
            }
        }
        body {
            div("main-block") {
                div("left-part") {
                    h1 { +"Registra un nuovo cliente" }
                    p { +"Basta inserire il nome, le note possono essere opzionali" }
                }
                form(action = "/api/client", method = FormMethod.post) {
                    div("title") {
                        i("fas fa-pencil-alt")
                        h2 { +"Register here" }
                    }
                    div("info") {
                        input(classes = "fname", type = InputType.text, name = "name") {
                            placeholder = "Nome"
                        }
                        textArea(rows = "10") {
                            name = "note"
                            placeholder = "Note"
                        }
                    }
                    button(type = ButtonType.submit) { +"Submit" }
                }
            }
        }
    }
}