package paolopasianot.it.html

import io.ktor.server.html.*
import kotlinx.html.*

data class WeatherStationUI(
    val name: String,
    val description: String
)

class WeatherStationCard (
    private val station:  WeatherStationUI
): Template<FlowContent> {

    override fun FlowContent.apply() {
        div(classes = "weather-station-card") {
            img(classes = "weather-station-card-img") { src="static/weather_station.png"; alt="Avatar"; style="width:100%" }
            div(classes = "weather-station-card-container"){
                h4 {
                    b { +station.name }
                }
                p{ +station.description }
            }
        }
    }
}