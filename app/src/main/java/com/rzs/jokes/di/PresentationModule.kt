package com.rzs.jokes.di

import com.rzs.jokes.di.DataModule.provideRepositoryImpl
import com.rzs.jokes.presentation.joke.factory.JokesViewModelFactory

object PresentationModule {
    val provideViewModelFactory: JokesViewModelFactory by lazy {
        JokesViewModelFactory (provideRepositoryImpl)
    }
}