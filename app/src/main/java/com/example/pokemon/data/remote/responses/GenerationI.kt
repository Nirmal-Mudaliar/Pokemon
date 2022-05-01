package com.example.pokemon.data.remote.responses

import com.squareup.moshi.Json

data class GenerationI(
    @field:Json(name = "red-blue") val red_blue: RedBlue,
    val yellow: Yellow
)