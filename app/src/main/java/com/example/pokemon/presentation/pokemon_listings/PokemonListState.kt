package com.example.pokemon.presentation.pokemon_listings

import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.domain.models.PokemonListEntry

data class PokemonListState(
    var pokemonsList: List<PokemonListEntry> = emptyList(),
    var searchQuery: String = "",
    var loadError: String = "",
    var endReached: Boolean = false,
    var isLoading: Boolean = false,
    var isSearching: Boolean = false
)
