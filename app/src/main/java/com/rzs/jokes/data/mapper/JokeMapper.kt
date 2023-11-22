package com.rzs.jokes.data.mapper

import com.rzs.jokes.data.remote.model.JokeApiModel
import com.rzs.jokes.presentation.joke.model.JokeAttrs

class JokeMapper {
    fun JokeApiModel.toAttrs() = JokeAttrs(
        error = error ?: true,
        category = category.orEmpty(),
        type = type.orEmpty(),
        joke = joke.orEmpty(),
        question = setup.orEmpty(),
        response = delivery.orEmpty()
    )
}