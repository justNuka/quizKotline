
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

private val repository = QuizRepository()

@Composable
internal fun App() {
    MaterialTheme {
        MaterialTheme {
            rootNavHost()
        }
    }
}

//expect fun getPlatformName(): String