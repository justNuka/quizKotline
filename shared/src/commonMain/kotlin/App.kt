
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
internal fun App() {
    MaterialTheme {
        rootNavHost()
    }
}

//expect fun getPlatformName(): String