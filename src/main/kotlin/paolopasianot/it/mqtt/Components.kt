package paolopasianot.it.mqtt

import org.eclipse.paho.mqttv5.common.MqttMessage

typealias MessageListener = suspend TopicContext.(message: MqttMessage) -> Unit

sealed interface QualityOfService {
    val level: Int
}

data object AtMostOnce : QualityOfService {
    override val level: Int = 0
}

data object AtLeastOnce : QualityOfService {
    override val level: Int = 1
}

data object ExactlyOnce : QualityOfService {
    override val level: Int = 2
}

data class TopicSubscription(val topic: Topic, val qualityOfService: QualityOfService)

@JvmInline
value class Topic(val value: String)