package network.data

@kotlinx.serialization.Serializable
data class Question(val id: Int, val label: String, val correctAnswerId: Int, val answers: List<Answer>)