import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import network.data.Answer
import network.data.Question

private val repository = QuizRepository()

@Composable
internal fun App() {
    MaterialTheme {
        val questions = repository.questionState.collectAsState()

        if(questions.value.isNotEmpty()) {
            questionScreen(questions.value)
        }
    }
}

expect fun getPlatformName(): String