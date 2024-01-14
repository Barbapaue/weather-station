package paolopasianot.it.html

import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.div
import paolopasianot.it.html.components.commons.weatherNavigationBar
import paolopasianot.it.html.components.commons.weatherStickyHeader
import paolopasianot.it.html.components.dashboard.weatherDashboard
import paolopasianot.it.html.model.Pages

fun HTML.index(){
    attributes["data-bs-theme"] = "dark"

    weatherHeader()

    body {
        weatherStickyHeader()

        div(classes = "container-fluid") {
            div(classes = "row") {
                weatherNavigationBar(currentPage = Pages.HOME)

                weatherDashboard()
            }
        }

        weatherFooter()
    }
}