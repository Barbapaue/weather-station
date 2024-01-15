package paolopasianot.it.localization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/*
@Serializable
class Localize private constructor(
    @SerialName("title")
    val title: String
) {

    companion object {
        @Volatile
        private var instance: Localize? = null

        fun getInstance(): Localize {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        Json {  }.decodeFromString()
                        instance = Localize()
                    }
                }
            }
            return instance!!
        }
    }
}*/
