package com.example.pokemon.data.remote.responses

import com.squareup.moshi.Json

data class GenerationV(
    @field:Json(name = "black-white") val black_white: BlackWhite
)