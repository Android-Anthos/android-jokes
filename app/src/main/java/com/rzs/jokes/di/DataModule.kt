package com.rzs.jokes.di

import com.rzs.jokes.data.JokeRepositoryImpl
import com.rzs.jokes.data.mapper.JokeMapper
import com.rzs.jokes.data.remote.JokeDataSourceImpl
import com.rzs.jokes.data.remote.api.JokesApi
import com.rzs.jokes.data.remote.api.config.UrlProvider.getJokesUrl
import com.rzs.jokes.data.source.JokeDataSource
import com.rzs.jokes.presentation.repository.JokeRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object DataModule {
    private val provideJokeApi: JokesApi by lazy {
        val urlBase = getJokesUrl()
        Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    private val provideDataSourceImpl:JokeDataSource by lazy {
        JokeDataSourceImpl(provideJokeApi)
    }
    private val provideJokeMapper:JokeMapper by lazy {
        JokeMapper()
    }
    val provideRepositoryImpl:JokeRepository by lazy {
        JokeRepositoryImpl(provideDataSourceImpl, provideJokeMapper)
    }

}