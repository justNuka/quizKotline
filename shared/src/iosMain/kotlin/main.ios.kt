
import moe.tlaster.precompose.PreComposeApplication
import platform.UIKit.UIViewController

actual fun getPlatformName(): String = "iOS"

//fun MainViewController() = ComposeUIViewController {
    //App()
//}

fun MainViewController(): UIViewController =
    PreComposeApplication() {
        App()
    }