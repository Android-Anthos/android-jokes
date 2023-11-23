package com.rzs.jokes.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rzs.jokes.data.remote.model.Constants.CATEGORY
import com.rzs.jokes.data.remote.model.Constants.DELIVERY
import com.rzs.jokes.data.remote.model.Constants.ERROR
import com.rzs.jokes.data.remote.model.Constants.JOKE
import com.rzs.jokes.data.remote.model.Constants.SETUP
import com.rzs.jokes.data.remote.model.Constants.TYPE

data class JokeApiModel(
    @SerializedName(ERROR) val error: Boolean?,
    @SerializedName(CATEGORY) val category: String?,
    @SerializedName(TYPE) val type: String?,
    @SerializedName(JOKE) val joke: String?,
    @SerializedName(SETUP) val setup: String?,
    @SerializedName(DELIVERY) val delivery: String?

)
