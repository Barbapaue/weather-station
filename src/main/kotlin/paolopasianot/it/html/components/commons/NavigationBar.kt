package paolopasianot.it.html.components.commons

import kotlinx.html.*
import paolopasianot.it.html.model.Pages

fun DIV.weatherNavigationBar(currentPage: Pages) {
    div(classes = "sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary") {
        div(classes = "offcanvas-md offcanvas-end bg-body-tertiary") {
            attributes["tabindex"] = "-1"
            attributes["aria-labelledby"] = "sidebarMenuLabel"
            id = "sidebarMenu"

            div(classes = "offcanvas-header"){
                h5(classes = "offcanvas-title") {
                    id = "sidebarMenuLabel"
                    + "Weather Station"
                }
                button(classes = "btn-close", type = ButtonType.button) {
                    attributes["data-bs-dismiss"] = "offcanvas"
                    attributes["data-bs-target"] = "#sidebarMenu"
                    attributes["aria-label"] = "Close"
                }
            }

            div(classes = "offcanvas-body d-md-flex flex-column p-0 pt-lg-3 overflow-y-auto"){
                ul(classes = "nav flex-column") {
                    Pages.entries.forEach {page ->
                        li(classes = "nav-item") {
                            a(classes = "nav-link d-flex align-items-center gap-2 ${if (page == currentPage) "active" else ""}", href = page.href) {
                                attributes["aria-current"] = "page"
                                + page.title
                            }
                        }
                    }
                }
            }
        }
    }
}