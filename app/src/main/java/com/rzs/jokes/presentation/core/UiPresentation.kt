package com.rzs.jokes.presentation.core

interface UiPresentation <TUiState: UiState> {
    fun renderUiStates(uiState: TUiState)
}