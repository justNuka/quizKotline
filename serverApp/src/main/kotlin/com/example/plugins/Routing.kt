package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Serializable
data class Answer(
    val id: Int,
    val label: String
)

@Serializable
data class Question(
    val id: Int,
    val label: String,
    @SerialName("correct_answer_id")
    val correctAnswerId: Int,
    val answers: List<Answer>
)

@Serializable
data class Quiz(
    val questions: List<Question>
)

fun fillQuizFromJson(jsonString: String): Quiz {
    return Json.decodeFromString(jsonString)
}

fun quizToJsonString(quiz: Quiz): String {
    return Json.encodeToString(quiz)
}

fun selectRandomQuiz(allQuestions: List<Question>, numberOfQuestions: Int): Quiz {
    val selectedQuestions = allQuestions.shuffled().take(numberOfQuestions)
    return Quiz(selectedQuestions)
}
fun Application.configureRouting() {
    routing {
        get("/healthcheck") {
            call.respondText("true")
        }
        get("/size"){
            val quiz = fillQuizFromJson(this.javaClass.classLoader.getResource("sef.json").readText())
            call.respondText(quiz.questions.size.toString())
        }
        get("/quizz") {
            call.respondText(this.javaClass.classLoader.getResource("sef.json").readText())
        }
        get("/quizz/{nb}")  {
            val Quests = fillQuizFromJson(this.javaClass.classLoader.getResource("sef.json").readText()).questions
            val strla = quizToJsonString(selectRandomQuiz(Quests, call.parameters["nb"]?.toInt() ?: 10))
            call.respondText(strla)
        }
    }
}
