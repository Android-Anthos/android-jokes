package com.rzs.jokes.presentation.joke.model

data class JokeAttrs(
    val error: Boolean,
    val category: String,
    val type: String,
    val joke: String,
    val question: String,
    val response: String
)