package com.rzs.jokes.presentation.repository

import com.rzs.jokes.presentation.joke.model.JokeAttrs

interface  JokeRepository {
    suspend fun getRandomJoke(lang:String): JokeAttrs
}