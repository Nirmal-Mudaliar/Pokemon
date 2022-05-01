package com.example.pokemon.data.remote.responses

import com.squareup.moshi.Json

data class Versions(
    @field:Json(name = "generation-i") val generation_i: GenerationI,
    @field:Json(name = "generation-ii") val generation_ii: GenerationIi,
    @field:Json(name = "generation-iii") val generation_iii: GenerationIii,
    @field:Json(name = "generation-iv") val generation_iv: GenerationIv,
    @field:Json(name = "generation-v") val generation_v: GenerationV,
    @field:Json(name = "generation-vi") val generation_vi: GenerationVi,
    @field:Json(name = "generation-vii") val generation_vii: GenerationVii,
    @field:Json(name = "generation-viii") val generation_viii: GenerationViii
)