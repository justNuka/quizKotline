package com.example

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import com.example.network.QuizRepository
import com.example.network.data.Question
import questionScreen
import scoreScreen
import welcomeScreen

private var quizRepository = QuizRepository()
private var questions = listOf<Question>()

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

                questionScreen(navigator, quizRepository,nbQuestion)


            }

        }
        scene(
            route = "/score/{score}",
            navTransition = NavTransition(),
        ) { backStackEntry ->
            backStackEntry.path<String>("score")?.let { score ->
                questions= listOf()
                scoreScreen(navigator, score)
            }
        }
    }
}