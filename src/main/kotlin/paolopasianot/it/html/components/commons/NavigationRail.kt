package paolopasianot.it.html.components.commons

import kotlinx.html.*
import paolopasianot.it.html.model.IndexPages

fun BODY.navigationRail(
    currentPage: IndexPages
) {
    //Container
    aside(classes = "navigation-rail") {
        span(classes = "navigation-rail-menu-icon material-symbols-outlined md-48 md-color-on-surface") {
            +"menu"
        }//APP IMAGE

        nav(classes = "navigation-rail-icons") {
            ul {
                IndexPages.entries.forEach { page ->
                    li {
                        a(href = page.href) {
                            span(
                                classes = "material-symbols-outlined md-24 ${if(currentPage == page) "md-color-on-primary-container icon-selected" else ""}"
                            ) { +page.icon }
                            p(classes = "icon") { +page.title }
                        }
                    }
                }
            }
        }// Navigation icons
    }
}