package paolopasianot.it.html

import kotlinx.html.*
import paolopasianot.it.html.components.commons.scrollBackTop
import paolopasianot.it.html.components.commons.sidebar
import paolopasianot.it.html.components.commons.topBar
import paolopasianot.it.html.components.dashboard.dashboard
import paolopasianot.it.html.model.Pages

fun HTML.index(current: Pages){
    weatherHeader()

    body {
        id = "page-top"

        div {
           id = "wrapper"

            sidebar()

            div(classes = "d-flex flex-column"){
                id = "content-wrapper"

                div(classes = "content") {
                    topBar()

                    div(classes = "container-fluid") {
                        div(classes = "d-sm-flex align-items-center justify-content-between mb-4") {
                            h1(classes = "h3 mb-0 text-gray-800") { + "Dashboard" }
                        }
                    }

                    dashboard()
                }

                footer(classes = "sticky-footer bg-white") {
                    div(classes = "container my-auto"){
                        div(classes = "copyright text-center my-auto"){
                            span { + "Copyright &copy; Weather Station 2024" }
                        }
                    }
                }
            }
        }

        scrollBackTop()

        weatherFooter()
    }
}