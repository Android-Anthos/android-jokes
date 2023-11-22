package com.rzs.jokes.presentation.joke

import com.rzs.jokes.presentation.core.UiState
import com.rzs.jokes.presentation.joke.model.JokeAttrs

sealed class JokeUiState:UiState {
    object LoadingUiState:JokeUiState()

    data class ShowJokeUiState(val jokeAttrs: JokeAttrs):JokeUiState()

    object ErrorUiState:JokeUiState()

}