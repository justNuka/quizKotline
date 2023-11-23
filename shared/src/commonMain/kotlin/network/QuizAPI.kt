package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.data.Quiz

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
        return httpClient.get("https://quiz.leod1.fr/quizz/$number").body()
    }
    suspend fun getMaxQuestions(): Int{
        println("max: ${httpClient.get("https://quiz.leod1.fr/size").body<String>()}")
        return httpClient.get("https://quiz.leod1.fr/size").body()
    }
}
