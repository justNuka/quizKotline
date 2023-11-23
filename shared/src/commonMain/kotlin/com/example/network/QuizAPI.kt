package com.example.network

import com.example.network.data.Answer
import com.example.network.data.Question
import com.example.network.data.Quiz
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class QuizAPI {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                contentType = ContentType.Text.Plain, // because Github is not returning an 'application/json' header
                json = Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
        }
    }
    suspend fun getQuestions(number: Int): Quiz{
        println("quiz Api: Ask for $number questions")
        try {
            return httpClient.get("https://quiz.leod1.fr/quizz/$number").body()
        }
        catch (e: Exception) {
            return Quiz(
                questions = listOf(
                    Question(
                        1,
                        "True or false? When your app goes into the background, it's not guaranteed to be destroyed. It may only be stopping and waiting for the user to return to it.",
                        1,
                        listOf(Answer(1, "True"), Answer(2, "False"))
                    ),
                    Question(
                        2,
                        "To keep the UI running smoothly, use ___ for long-running tasks, such as all database operations.",
                        2,
                        listOf(
                            Answer(1, "Coroutines"),
                            Answer(2, "ViewModels"),
                            Answer(3, "Returns"),
                            Answer(4, "Managed threads")
                        )
                    ),
                    Question(
                        3,
                        "What is the name of the Gradle plugin that enables you to write Kotlin code for your Gradle build files?",
                        3,
                        listOf(
                            Answer(1, "Kotlin Gradle plugin"),
                            Answer(2, "Kotlin DSL plugin"),
                            Answer(3, "Kotlin build plugin"),
                            Answer(4, "Kotlin build tools plugin")
                        )
                    ),
                    Question(
                        4,
                        "You can create an emulator to simulate the configuration of a particular type of Android device using a tool like",
                        3,
                        listOf(
                            Answer(1, "Theme Editor"),
                            Answer(2, "Android SDK Manager"),
                            Answer(3, "AVD Manager"),
                            Answer(4, "Virtual Editor")
                        )
                    ),
                    Question(
                        5,
                        "What parameter specifies the Android API level that Gradle should use to compile your app?",
                        2,
                        listOf(
                            Answer(1, "minSdkVersion"),
                            Answer(2, "Android SDK Manager"),
                            Answer(3, "AVD Manager"),
                            Answer(4, "Virtual Editor")
                        )
                    ),
                )
            )
        }
    }
    suspend fun getMaxQuestions(): Int{
        println("max: ${httpClient.get("https://quiz.leod1.fr/size").body<String>()}")
        try {
            return httpClient.get("https://quiz.leod1.fr/size").body()
        }catch (e: Exception){
            return 5
        }

    }
}