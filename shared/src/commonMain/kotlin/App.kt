
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.rootNavHost

@Composable
internal fun App() {
    MaterialTheme {
        rootNavHost()
    }
}

//expect fun getPlatformName(): String