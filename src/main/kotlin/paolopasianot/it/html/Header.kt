package paolopasianot.it.html

import kotlinx.html.*
import paolopasianot.it.html.model.Theme
import paolopasianot.it.html.model.Theme.*
import paolopasianot.it.html.model.WebsiteCoreData
import paolopasianot.it.html.model.favicon

/**
 * generate default header
 *
 * @param myStyle use to put other custom style after reset and index style
 */
fun HTML.weatherHeader(
    data: WebsiteCoreData,
    myStyle: HEAD.() -> Unit
) {
    title = data.title
    lang = data.lang.toHTML

    head {

        favicon(data.icon)

        //META
        meta(
            name = "viewport",
            content = "width=device-width, initial-scale=1.0, maximum-scale=1.0, target-densitydpi=device-dpi"
        )
        meta(content = data.lang.toHTML) {
            attributes["http-equiv"] = "Content-Language"
        }
        meta(content = "text/html; charset=UTF-8") {
            attributes["http-equiv"] = "Content-Type"
        }

        //FONT
        link(rel = "preconnect", href = "https://fonts.googleapis.com")
        link(rel = "preconnect", href = "https://fonts.gstatic.com"){
            attributes["crossorigin"] = ""
        }
        link(
            href = "https://fonts.googleapis.com/css2?family=Roboto&display=swap",
            rel = "stylesheet"
        )

        //ICONS
        link(
            href = "https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined",
            rel = "stylesheet"
        )

        //STYLE
        link(href = "static/css/reset.css", rel = "stylesheet") //reset default web browser style
        link(href = "static/css/theme/color.css", rel = "stylesheet")
        when(data.theme){
            LIGHT -> link(href = "static/css/theme/theme-light.css", rel = "stylesheet")
            DARK -> link(href = "static/css/theme/theme-dark.css", rel = "stylesheet")
        }
        link(href = "static/css/theme/icons.css", rel = "stylesheet")
        link(href = "static/css/theme/button.css", rel = "stylesheet")
        link(href = "static/css/theme/navigation-rail.css", rel = "stylesheet")
        link(href = "static/css/index.css", rel = "stylesheet")
        myStyle()

    }
}
