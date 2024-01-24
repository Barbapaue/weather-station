package paolopasianot.it.plugins

import io.ktor.server.application.*
import paolopasianot.it.mqtt.AtMostOnce
import paolopasianot.it.mqtt.Mqtt
import paolopasianot.it.mqtt.Topic
import paolopasianot.it.mqtt.TopicSubscription

fun Application.configureMqtt(){
    //val microbit = Topic("topicName/led")
    //val microbitTopicSubscription = TopicSubscription(microbit, AtMostOnce)

    // Installs the plugin to the server so that you can use it, won't work otherwise
    install(Mqtt) {
        broker = "ssl://51b2bb9205ec44e2b78febd6e6bdc526.s2.eu.hivemq.cloud:8883"
        autoConnect = true
        this.clientId = "webapplication"

        connectionOptions {
            this.userName = "MyWeatherWhatTheFuck"
            this.password = "hEfwi7-wazcij-zoqsaj".toByteArray()

        }
        //initialSubscriptions(microbitTopicSubscription)
    }
}