package com.rzs.jokes.presentation.joke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rzs.jokes.presentation.core.ViewModelPresentation
import com.rzs.jokes.presentation.repository.JokeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class JokesViewModel(private val repository: JokeRepository) : ViewModel(),
    ViewModelPresentation<JokeUiEvent, JokeUiState> {
    private val initialUiState: JokeUiState = JokeUiState.LoadingUiState
    private val uiState = MutableStateFlow(initialUiState)

    override fun processUiEvent(uiEvent: JokeUiEvent) {
        when (uiEvent) {
            is JokeUiEvent.InitialUiEvent -> {
                getJoke(uiEvent.lang)

            }
            is JokeUiEvent.GetAnotherJokeUiEvent -> {
                getJoke(uiEvent.lang)
            }
        }

    }
    private fun getJoke(lang: String) {
        uiState.update { JokeUiState.LoadingUiState }
        viewModelScope.launch {
            runCatching {
                repository.getRandomJoke(lang)
            }.onSuccess { joke ->
                uiState.update { JokeUiState.ShowJokeUiState(joke) }
            }.onFailure {
                uiState.update { JokeUiState.ErrorUiState }
            }
        }
    }

    override fun uiState(): StateFlow<JokeUiState> = uiState.asStateFlow()

}