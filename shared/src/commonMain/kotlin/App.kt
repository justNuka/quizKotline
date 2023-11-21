import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import network.data.Answer
import network.data.Question

@Composable
internal fun App() {
    MaterialTheme {
        var questions = listOf(
            Question(
                1,
                "Android is a great platform ?",
                1,
                listOf(Answer(1, "YES"), Answer(2, "NO"))
            ),
            Question(
                1,
                "Android is a bad platform ?",
                2,
                listOf(Answer(1, "YES"), Answer(2, "NO"))
            )
        )
        questionScreen(questions)
    }
}

expect fun getPlatformName(): String