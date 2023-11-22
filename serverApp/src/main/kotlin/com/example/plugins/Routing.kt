package com.example.plugins

import io.ktor.http.ContentType.Application.Json
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File


fun readJsonFile(filePath: String): String {
    try {
        // Read the JSON file content as a string
        val jsonContent = File(filePath).readText()

        // If you just want to return the raw JSON content, you can do this:
        return jsonContent
    } catch (e: Exception) {
        e.printStackTrace()
        return "null"
    }
}
fun QuizzData(): String {
    return "{\n" +
            "  \"questions\": [\n" +
            "    { \n" +
            "    \"id\":1, \n" +
            "    \"label\":\"You can create an emulator to simulate the configuration of a particular type of Android device using a tool like\", \n" +
            "    \"correct_answer_id\":3, \n" +
            "    \"answers\":[\n" +
            "      {\"id\":1, \"label\":\"Theme Editor\"},\n" +
            "      {\"id\":2, \"label\":\"Android SDK Manager\"},\n" +
            "      {\"id\":3, \"label\":\"AVD Manager\"},\n" +
            "      {\"id\":4, \"label\":\"Virtual Editor\"}\n" +
            "     ]\n" +
            "    },\n" +
            "    {\n" +
            "    \"id\":2, \n" +
            "    \"label\":\"What parameter specifies the Android API level that Gradle should use to compile your app?\", \n" +
            "    \"correct_answer_id\":2, \n" +
            "    \"answers\":[\n" +
            "      {\"id\":1, \"label\":\"minSdkVersion\"},\n" +
            "      {\"id\":2, \"label\":\"compileSdkVersion\"},\n" +
            "      {\"id\":3, \"label\":\"targetSdkVersion\"},\n" +
            "      {\"id\":4, \"label\":\"testSdkVersion\"}\n" +
            "     ]\n" +
            "    },\n" +
            "     {\n" +
            "    \"id\":3, \n" +
            "    \"label\":\"True or false? Scroll view can contain only one view, or view group, as a child ?\", \n" +
            "    \"correct_answer_id\":1, \n" +
            "    \"answers\":[\n" +
            "      {\"id\":1, \"label\":\"True\"},\n" +
            "      {\"id\":2, \"label\":\"False\"}\n" +
            "     ]\n" +
            "    },\n" +
            "     {\n" +
            "    \"id\":4, \n" +
            "    \"label\":\"What phrase means that the compiler validates types while compiling?\", \n" +
            "    \"correct_answer_id\":1, \n" +
            "    \"answers\":[\n" +
            "      {\"id\":1, \"label\":\"Type safety\"},\n" +
            "      {\"id\":2, \"label\":\"Data binding\"},\n" +
            "      {\"id\":3, \"label\":\"Type validation\"},\n" +
            "      {\"id\":4, \"label\":\"Wrong text\"}\n" +
            "     ]\n" +
            "    },\n" +
            "     {\n" +
            "    \"id\":5, \n" +
            "    \"label\":\"True or false? When your app goes into the background, it's not guaranteed to be destroyed. It may only be stopping and waiting for the user to return to it.\", \n" +
            "    \"correct_answer_id\":1, \n" +
            "    \"answers\":[\n" +
            "      {\"id\":1, \"label\":\"True\"},\n" +
            "      {\"id\":2, \"label\":\"False\"}\n" +
            "     ]\n" +
            "    },\n" +
            "     {\n" +
            "    \"id\":6, \n" +
            "    \"label\":\"To keep the UI running smoothly, use ___ for long-running tasks, such as all database operations.\", \n" +
            "    \"correct_answer_id\":1, \n" +
            "    \"answers\":[\n" +
            "      {\"id\":1, \"label\":\"Coroutines\"},\n" +
            "      {\"id\":2, \"label\":\"ViewModels\"},\n" +
            "      {\"id\":3, \"label\":\"Returns\"},\n" +
            "      {\"id\":4, \"label\":\"Managed threads\"}\n" +
            "     ]\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}
fun Application.configureRouting() {
    routing {
        get("/healthcheck") {
            call.respondText("true")
        }
        get("/quizz") {
            //call.respondText(QuizzData())
            call.respondText(readJsonFile("C:\\Users\\Elève\\Desktop"))
        }
    }
}
