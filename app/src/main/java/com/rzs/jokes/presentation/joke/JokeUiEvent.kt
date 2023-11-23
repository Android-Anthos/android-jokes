package com.rzs.jokes.presentation.joke

import com.rzs.jokes.presentation.core.UiEvent

sealed class JokeUiEvent:UiEvent {
    data class InitialUiEvent(val lang: String):JokeUiEvent()
    data class GetAnotherJokeUiEvent(val lang: String):JokeUiEvent()
}