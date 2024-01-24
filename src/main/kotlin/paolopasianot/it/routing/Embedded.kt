package paolopasianot.it.routing

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import paolopasianot.it.mqtt.AtMostOnce
import paolopasianot.it.mqtt.topic

fun Routing.embedded(){
    topic("client/001/station/001/debug/counter", AtMostOnce){
        println(String(it.payload))
    }




}