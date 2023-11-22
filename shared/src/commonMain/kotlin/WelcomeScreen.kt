import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
internal fun welcomeScreen(navigator: Navigator) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.LightGray)
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.padding(10.dp)
                .border(
                    shape = RoundedCornerShape(15.dp),
                    color = Color.Black,
                    width = 1.dp
                ),

        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {


                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Quiz",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(all = 10.dp)
                    )
                    Text(
                        modifier = Modifier.padding(all = 10.dp),
                        text = "A simple Quiz to discovers KMP and compose.",
                    )
                    Button(
                        modifier = Modifier.padding(all = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        onClick = { navigator.navigate(route = "/quiz") }

                    ) {
                        Text("Start the Quiz")
                    }
                }
            }
        }
    }
}