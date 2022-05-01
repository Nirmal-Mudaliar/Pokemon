package com.example.pokemon.data.remote.responses

import com.squareup.moshi.Json

data class Other(
    val dream_world: DreamWorld,
    val home: Home,
    @field:Json(name = "official-artwork") val official_artwork: OfficialArtwork
)