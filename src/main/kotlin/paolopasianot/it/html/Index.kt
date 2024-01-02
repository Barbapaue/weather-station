package paolopasianot.it.html

import io.ktor.server.html.*
import kotlinx.html.*

class Index(
    private val list: List<WeatherStationUI>
) : Template<HTML> {
    val ulNavigationItems = Placeholder<FlowContent>()
    private val content = TemplatePlaceholder<WeatherStationCard>()
    override fun HTML.apply() {
        head {
            link {
                rel = "stylesheet"
                href = "/static/index.css"
            }
        }
        body {
            noScript { }
            input { type = InputType.checkBox; id = "drawer-toggle"; name = "drawer-toggle" }
            label { htmlFor = "drawer-toggle"; id = "drawer-toggle-label" }
            header { +"Weather Stations" }
            nav {
                id = "drawer"
                insert(ulNavigationItems)
            }
            div {
                id = "page-content"
                list.forEach { weatherStation ->
                    insert(WeatherStationCard(station = weatherStation), content)
                }
            }

        }
    }

}