package com.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import com.example.network.QuizRepository

private var quizRepository = QuizRepository()

@Composable
internal fun rootNavHost() {

    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        navTransition = NavTransition(),
        initialRoute = "/welcome",
    ) {
        scene(
            route = "/welcome",
            navTransition = NavTransition(),
        ) {
            quizRepository.getMaxSize()
             welcomeScreen(navigator,quizRepository)
        }
        scene(
            route = "/quiz/{nbQuestion}",
            navTransition = NavTransition(),
        ) { backStackEntry ->
            backStackEntry.path<Int>("nbQuestion")?.let { nbQuestion ->
                println("nav host: $nbQuestion")

                val questions = quizRepository.questionState.collectAsState()

                if (questions.value.isNotEmpty()) {
                    questionScreen(navigator, questions.value)
                } else
                    quizRepository.updateQuiz(nbQuestion)

            }

        }
        scene(
            route = "/score/{score}",
            navTransition = NavTransition(),
        ) { backStackEntry ->
            backStackEntry.path<String>("score")?.let { score ->
                scoreScreen(navigator, score)
            }
        }
    }
}