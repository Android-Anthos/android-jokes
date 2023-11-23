package com.rzs.jokes.data.source

import com.rzs.jokes.data.remote.model.JokeApiModel

interface JokeDataSource {
    suspend fun getRandomJoke(lang:String):JokeApiModel
}