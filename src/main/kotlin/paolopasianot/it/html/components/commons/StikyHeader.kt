package paolopasianot.it.html.components.commons

import kotlinx.html.*

fun BODY.weatherStickyHeader(){
    header(classes = "navbar sticky-top bg-dark flex-md-nowrap p-0 shadow") {
        attributes["data-bs-theme"] = "dark"
        a(href = "#", classes = "navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6 text-white"){
            + "Weather Station"
        }

        ul(classes = "navbar-nav flex-row d-md-none") {
            li(classes = "nav-item text-nowrap") {
                button(classes = "nav-link px-3 text-white", type = ButtonType.button, ) {
                    attributes["data-bs-toggle"] = "offcanvas"
                    attributes["data-bs-target"] = "#sidebarMenu"
                    attributes["aria-controls"] = "sidebarMenu"
                    attributes["aria-expanded"] = "false"
                    attributes["aria-label"] = "Toggle navigation"
                    svg(classes = "bi"){
                        unsafe {
                            + "<use xlink:href=\"#list\"></use>"
                        }
                    }
                }
            }
        }
    }
}