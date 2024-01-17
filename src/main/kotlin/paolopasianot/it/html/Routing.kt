package paolopasianot.it.html

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import paolopasianot.it.html.model.IndexPages
import paolopasianot.it.html.model.SupportedLangs
import paolopasianot.it.html.model.Theme
import paolopasianot.it.html.model.WebsiteCoreData

fun Route.webPage(){
    val webPageData =  WebsiteCoreData(
        lang = SupportedLangs.IT,
        title = "Weather Station",
        theme = Theme.LIGHT,
        icon = WebsiteCoreData.Icon(
            faviconRootPath = "/static/img/favicon"
        )
    )
    home(webPageData)
    database(webPageData)
}

private fun Route.home(data: WebsiteCoreData){
    get("/") {
        call.respondHtml {
            index(
                data,
                indexPages = IndexPages.HOME
            )
        }
    }
    get("/index") {
        call.respondHtml {
            index(
                data,
                indexPages = IndexPages.HOME
            )
        }
    }
    get("/home") {
        call.respondHtml {
            index(
                data,
                indexPages = IndexPages.HOME
            )
        }
    }
}

private fun Route.database(data: WebsiteCoreData){
    get("/database"){
        call.respondHtml {
            index(
                data,
                indexPages = IndexPages.DATABASE
            )
        }
    }
}
