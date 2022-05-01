package com.example.pokemon.data.remote.responses

import com.squareup.moshi.Json

data class GenerationIii(
    val emerald: Emerald,
    @field:Json(name = "firered-leafgreen") val firered_leafgreen: FireredLeafgreen,
    @field:Json(name = "ruby-sapphire") val ruby_sapphire: RubySapphire
)