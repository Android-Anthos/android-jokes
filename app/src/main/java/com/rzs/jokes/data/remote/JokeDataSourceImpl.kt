package com.rzs.jokes.data.remote

import com.rzs.jokes.data.remote.api.JokesApi
import com.rzs.jokes.data.remote.model.JokeApiModel
import com.rzs.jokes.data.source.JokeDataSource

class JokeDataSourceImpl constructor(private val api:JokesApi):JokeDataSource {

    override suspend fun getRandomJoke(lang: String): JokeApiModel {
        return api.getRandomJoke(lang)
    }
}