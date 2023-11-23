package com.example.network

import com.example.network.data.Question
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuizRepository()  {

    private val quizAPI = QuizAPI()
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    private var _questionState=  MutableStateFlow(listOf<Question>())
    var questionState = _questionState

    private var _maxQuestionSize = MutableStateFlow(20)
    var maxQuestionSize = _maxQuestionSize
    init {
        //updateQuiz(number)
    }

    private suspend fun fetchQuiz(number : Int): List<Question> = quizAPI.getQuestions(number).questions

    private suspend fun fetchMaxQuestion(): Int = quizAPI.getMaxQuestions()
    fun updateQuiz(number: Int){

        coroutineScope.launch {
            _questionState.update { fetchQuiz(number) }
        }
    }
    fun getMaxSize(){
        coroutineScope.launch {
            _maxQuestionSize.update { fetchMaxQuestion() }
        }
    }
}