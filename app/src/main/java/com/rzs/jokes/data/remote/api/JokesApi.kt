package com.rzs.jokes.data.remote.api

import com.rzs.jokes.data.remote.model.Constants.LANG
import com.rzs.jokes.data.remote.model.JokeApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApi {

    @GET("Any")
    suspend fun getRandomJoke(@Query(LANG) lang: String): JokeApiModel


}