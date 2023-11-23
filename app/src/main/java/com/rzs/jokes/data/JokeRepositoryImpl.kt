package com.rzs.jokes.data

import com.rzs.jokes.data.mapper.JokeMapper
import com.rzs.jokes.data.source.JokeDataSource
import com.rzs.jokes.presentation.joke.model.JokeAttrs
import com.rzs.jokes.presentation.repository.JokeRepository

class JokeRepositoryImpl(
    private val remoteDataSource: JokeDataSource,
    private val mapper: JokeMapper
): JokeRepository {

    override suspend fun getRandomJoke(lang: String): JokeAttrs {
        val jokeApiModel = remoteDataSource.getRandomJoke(lang)
        return with(mapper) { jokeApiModel.toAttrs() }
    }

}