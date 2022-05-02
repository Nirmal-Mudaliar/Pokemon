package com.example.pokemon.presentation.pokemon_listings

import com.example.pokemon.data.remote.responses.PokemonList

data class PokemonListState(
    val pokemonsList: List<PokemonList> = emptyList(),
    val searchQuery: String = ""
)
