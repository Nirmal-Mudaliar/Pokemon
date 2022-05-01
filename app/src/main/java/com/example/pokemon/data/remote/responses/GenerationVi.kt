package com.example.pokemon.data.remote.responses

import com.squareup.moshi.Json

data class GenerationVi(
    @field:Json(name = "omegaruby-alphasapphire") val omegaruby_alphasapphire: OmegarubyAlphasapphire,
    @field:Json(name = "x-y") val x_y: XY
)