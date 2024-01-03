package paolopasianot.it.routing

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import paolopasianot.it.mqtt.AtMostOnce
import paolopasianot.it.mqtt.topic

fun Routing.embedded(){
    topic("testTopic", AtMostOnce){
        val message = it.toString()
        println(message)
    }

    post("/embedded") {
        println(call.receiveText())
    }


}