import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun scoreScreen(navigator: Navigator, score: String) {
    Box(
        //contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.LightGray)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(
                "Merci d'avoir joué!", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 50.dp)
            )

            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.padding(start = 30.dp)
                    .border(
                        shape = RoundedCornerShape(15.dp),
                        color = Color.Black,
                        width = 1.dp
                    ),
                backgroundColor = Color.Green

            ) {


                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        fontSize = 15.sp,
                        text = "score:",
                    )
                    Text(
                        fontSize = 30.sp,
                        text = score,
                    )
                    Button(
                        modifier = Modifier.padding(all = 20.dp),
                        shape = RoundedCornerShape(15.dp),
                        onClick = {
                            navigator.navigate(route = "/quiz")
                        }
                    ) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Localized description")
                        Text(text = "Retake the Quiz")

                    }
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier.padding(vertical= 20.dp)) {
                    AnimatedVisibility(true) {
                        Image(
                            painterResource("Images/Oops Emoji.png"),
                            contentDescription = "photo1",
                            modifier = Modifier.width(250.dp).padding(horizontal = 8.dp)
                        )
                    }
                    AnimatedVisibility(true) {
                        Image(
                            painterResource("Images/Oops Emoji.png"),
                            contentDescription = "photo2",
                            modifier = Modifier.width(250.dp).padding(horizontal = 8.dp)
                        )
                    }
                    AnimatedVisibility(true) {
                        Image(
                            painterResource("Images/Oops Emoji.png"),
                            contentDescription = "photo3",
                            modifier = Modifier.width(250.dp).padding(horizontal = 8.dp)
                        )
                    }
                }
            }

        }
    }

}