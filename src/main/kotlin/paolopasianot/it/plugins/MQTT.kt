package paolopasianot.it.plugins

import io.ktor.server.application.*
import paolopasianot.it.mqtt.AtMostOnce
import paolopasianot.it.mqtt.Mqtt
import paolopasianot.it.mqtt.Topic
import paolopasianot.it.mqtt.TopicSubscription

fun Application.configureMqtt(){
    val microbit = Topic("microbit")
    val microbitTopicSubscription = TopicSubscription(microbit, AtMostOnce)

    // Installs the plugin to the server so that you can use it, won't work otherwise
    install(Mqtt) {
        broker = "tcp://localhost:1883"
        autoConnect = true
        initialSubscriptions(microbitTopicSubscription)
    }
}