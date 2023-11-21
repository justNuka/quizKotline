@file:Suppress("PLUGIN_IS_NOT_ENABLED")

package network.data
import kotlinx.serialization.SerialInfo
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Question(val id: Int, val label: String, val correctAnswerId: Int, val answers: List<Answer>)