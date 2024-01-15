package paolopasianot.it.html.components.commons

import kotlinx.html.BODY
import kotlinx.html.a
import kotlinx.html.i

/***
 * bottone che fa tornare in testa alla pagina
 */
fun BODY.scrollBackTop(){
    a(classes = "scroll-to-top rounded", href = "#page-top") {
        i(classes = "fas fa-angle-up")
    }
}