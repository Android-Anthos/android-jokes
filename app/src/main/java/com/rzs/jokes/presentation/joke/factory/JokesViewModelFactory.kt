package com.rzs.jokes.presentation.joke.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rzs.jokes.presentation.joke.JokesViewModel
import com.rzs.jokes.presentation.repository.JokeRepository

class JokesViewModelFactory(private val repository: JokeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            JokesViewModel::class.java -> JokesViewModel(repository)
            else -> throw ClassNotFoundException(
                "You should register your ViewModel here so as to create it"
            )
        } as T
    }
}

