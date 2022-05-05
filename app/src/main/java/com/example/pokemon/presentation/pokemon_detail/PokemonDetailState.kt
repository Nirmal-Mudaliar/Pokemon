package com.example.pokemon.presentation.pokemon_detail

import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.util.Resource

data class PokemonDetailState(
    var pokemonInfo: Resource<Pokemon>
)
