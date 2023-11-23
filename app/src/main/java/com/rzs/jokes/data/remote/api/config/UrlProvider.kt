package com.rzs.jokes.data.remote.api.config

object UrlProvider {

    private const val BASE_URL = "https://v2.jokeapi.dev/joke/"

    fun getJokesUrl() = BASE_URL
}