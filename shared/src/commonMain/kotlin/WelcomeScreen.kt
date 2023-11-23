import androidx.compose.foundation.Image
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
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator
import network.QuizRepository
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import kotlin.math.roundToInt

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun welcomeScreen(navigator: Navigator,pQuizRepository: QuizRepository) {

    var questionSliderPosition by remember { mutableStateOf(10f) }
    val maxRange = 10f .. pQuizRepository.maxQuestionSize.collectAsState().value.toFloat()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.LightGray)
    ) {
        Image(
            painterResource("Images/question_icon.png"),
            null, alpha = 0.5f,
            modifier = Modifier.matchParentSize()
        )

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
                        onClick = { navigator.navigate(route = "/quiz/${questionSliderPosition.roundToInt()}") }

                    ) {
                        Text("Start the Quiz")
                    }
                }


                Text("number of questions: ${(questionSliderPosition).roundToInt()}",
                    modifier = Modifier.padding(top = 20.dp))
                //println("max slide: $maxQuestionSize")
                    Slider(
                        value = questionSliderPosition,
                        onValueChange = { questionSliderPosition = it },
                        modifier = Modifier.padding(horizontal = 150.dp),
                        valueRange = maxRange
                    )

            }
        }
    }
}