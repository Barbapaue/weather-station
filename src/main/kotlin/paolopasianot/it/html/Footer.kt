package paolopasianot.it.html

import kotlinx.html.BODY
import kotlinx.html.script

fun BODY.weatherFooter(){
    script(src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"){
        integrity = "sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        attributes["crossorigin"] = "anonymous"
    }
    script(src = "static/js/index.js"){

    }
}