package paolopasianot.it.html.components.commons

import kotlinx.html.*
import paolopasianot.it.html.model.DatabasePages

fun DIV.sidebar(){
    ul(classes = "navbar-nav bg-gradient-primary sidebar sidebar-dark accordion") {
        id = "accordionSidebar"

        a(classes = "sidebar-brand d-flex align-items-center justify-content-center", href = "/"){
            div(classes = "sidebar-brand-icon rotate-n-15") {
                i(classes = "fas fa-laugh-wink")
            }
            div(classes = "sidebar-brand-text mx-3"){
                + "Weather Station"
            }
        }

        //Divider
        divider()

        //Dashboard NavItems
        li(classes = "nav-item active"){
            a(classes = "nav-link", href = "/"){
                i(classes = "fas fa-fw fa-tachometer-alt")
                span { +"Dashboard" }
            }
        }

        divider()

        //Database
        div(classes = "sidebar-heading"){
            + "Gestione Dati"
        }

        li(classes="nav-item") {
            a(classes = "nav-link collapsed", href = "#"){
                attributes["data-toggle"] = "collapse"
                attributes["data-target"] = "#collapseTwo"
                attributes["aria-expanded"] = "true"
                attributes["aria-controls"] = "collapseTwo"

                span{ + "Database" }
            }
            div(classes = "collapse" ) {
                id = "collapseTwo"
                attributes["aria-labelledby"] = "headingTwo"
                attributes["data-parent"] = "#accordionSidebar"
                div (classes = "bg-white py-2 collapse-inner rounded"){
                    h6(classes = "collapse-header") { + "Tabelle" }
                    DatabasePages.entries.forEach {
                        a(classes = "collapse-item", href = it.href) { + it.menuName }
                    }
                }
            }
        }

        hr(classes = "sidebar-divider d-none d-md-block")

        //Collapse menu
        div(classes = "sidebar-divider d-none d-md-block") {
            button(classes = "rounded-circle border-0") {
                id = "sidebarToggle"
            }
        }

        //Message
        div(classes = "sidebar-card d-none d-lg-flex") {
            p(classes = "text-center mb-2"){
                strong { + "Weather Station" }
                + " l'applicativo è attualmente anche in "
                strong { + "BETA" }
            }
        }
    }
}


private fun UL.divider() {
    hr(classes = "sidebar-divider my-0")
}