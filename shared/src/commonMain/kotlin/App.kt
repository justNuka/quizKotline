
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import network.QuizRepository

private val repository = QuizRepository()

@Composable
internal fun App() {
    MaterialTheme {
        rootNavHost()
    }
}

//expect fun getPlatformName(): String