package com.example.pokemon.data.remote.responses

import com.squareup.moshi.Json

data class GenerationIv(
    @field:Json(name = "diamond-pearl") val diamond_pearl: DiamondPearl,
    @field:Json(name = "heartgold-soulsilver") val heartgold_soulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)