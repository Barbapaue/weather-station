package paolopasianot.it.html

import kotlinx.html.*

fun HTML.weatherHeader() {
    head {
        title = "Weather Station"
        //HEAD
        link(rel = "icon", href = "static/favicon.webp", type = "image/x-icon")
        link(rel = "shortcut icon", href = "static/favicon.webp", type = "image/x-icon")

        //META
        meta(
            name = "viewport",
            content = "width=device-width, initial-scale=1.0, maximum-scale=1.0, target-densitydpi=device-dpi"
        )
        meta(content = "IT") {
            attributes["http-equiv"] = "Content-Language"
        }
        meta(content = "text/html; charset=UTF-8") {
            attributes["http-equiv"] = "Content-Type"
        }

        //FONT
        link(
            href = "https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i",
            rel = "stylesheet"
        )
        link(
            href = "static/vendor/fontawesome-free/css/all.min.css",
            rel = "stylesheet"
        )

        //BOOTSTRAP
        link(href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css", rel = "stylesheet"){
            integrity = "sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            attributes["crossorigin"] = "anonymous"
        }

        //WEATHER STATION STYLE
        link(href = "static/css/weather_station.css", rel = "stylesheet")
    }
}
