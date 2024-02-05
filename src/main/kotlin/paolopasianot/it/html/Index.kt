package paolopasianot.it.html

import kotlinx.css.CssBuilder
import kotlinx.css.body
import kotlinx.html.*
import paolopasianot.it.html.components.commons.navigationRail
import paolopasianot.it.html.components.dashboard.home
import paolopasianot.it.html.model.IndexPages
import paolopasianot.it.html.model.IndexPages.*
import paolopasianot.it.html.model.WebsiteCoreData

fun HTML.index(websiteCoreData: WebsiteCoreData, indexPages: IndexPages){

    weatherHeader(websiteCoreData){

    }

    body {
        navigationRail(currentPage = indexPages)

        when(indexPages){
            HOME ->  home()
            DATABASE -> {

            }
        }

        indexFooter()
    }
}

val t = CssBuilder().apply{
    body{

    }
}