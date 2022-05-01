package com.example.pokemon.data.remote.responses

import com.squareup.moshi.Json

data class GenerationVii(
    val icons: Icons,
    @field:Json(name = "ultra-sun-ultra-moon") val ultra_sun_ultra_moon: UltraSunUltraMoon
)