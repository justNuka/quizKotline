import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import moe.tlaster.precompose.navigation.Navigator
import network.data.Question
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun questionScreen(navigator: Navigator, questions: List<Question>) {

    var questionProgress by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf(1) }
    var score by remember { mutableStateOf(0) }
    var valid by remember { mutableStateOf("question") }


    Box {
        Image(
            painterResource(getBackground(valid)),
            null, alpha = 0.5f,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.padding(60.dp)
                    .border(shape = RoundedCornerShape(15.dp), color = Color.Black, width = 1.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(all = 10.dp),
                        text = questions[questionProgress].label,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            //List of answer
            Column(modifier = Modifier.selectableGroup()) {
                questions[questionProgress].answers.forEach { answer ->
                    Card(
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 5.dp)
                            .border(
                                shape = RoundedCornerShape(15.dp),
                                color = Color.Black,
                                width = 1.dp
                            )
                            .background(Color.Transparent)
                            .width(400.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp)
                                .clickable { selectedAnswer = answer.id }
                                .width(400.dp),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {

                            RadioButton(
                                modifier = Modifier.padding(end = 16.dp),
                                selected = (selectedAnswer == answer.id),
                                onClick = { selectedAnswer = answer.id }
                            )
                            Text(text = answer.label)
                        }

                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                //valid button
                Button(
                    modifier = Modifier.padding(bottom = 20.dp),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {
                        valid = if (selectedAnswer == questions[questionProgress].correctAnswerId) {
                            score++
                            "success"
                        } else "invalid"


                    }
                ) {
                    if (questionProgress < questions.size - 1) nextOrDoneButton(
                        Icons.Filled.ArrowForward,
                        "Next"
                    )
                    else nextOrDoneButton(Icons.Filled.Done, "Done")
                }
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth().height(20.dp),
                    progress = questionProgress.div(questions.size.toFloat())
                        .plus(1.div(questions.size.toFloat()))
                )
                if (valid != "question") LaunchedEffect(valid) {
                    delay(500)
                    if (questionProgress < questions.size - 1) {
                        questionProgress++
                        selectedAnswer = 1
                    } else {
                        // Go to the score section
                        navigator.navigate("/score/$score out of ${questions.size}")
                    }
                    valid = "question"
                }
            }
        }
    }
}

// change background image depend answer
fun getBackground(pValid: String): String {
    when (pValid) {
        "success" -> return "Images/valid_icon.png"
        "question" -> return "Images/question_icon.png"
        "invalid" -> return "Images/invalid_icon.png"
    }
    return "Images/question_icon.png"
}

@Composable
internal fun nextOrDoneButton(iv: ImageVector, label: String) {
    Icon(
        iv,
        contentDescription = "Localized description",
        Modifier.padding(end = 15.dp)
    )
    Text(label)
}