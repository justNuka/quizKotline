package com.example

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.network.QuizRepository

private val repository = QuizRepository()

// Générer un mock de données, comme ca : si pas internet, on prend le mock de données
// au lieu de faire un appel réseau
//

@Composable
internal fun App() {
    MaterialTheme {
        rootNavHost()
    }
}

//expect fun getPlatformName(): String