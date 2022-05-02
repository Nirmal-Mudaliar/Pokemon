package com.example.pokemon.presentation.pokemon_listings

sealed class PokemonListingEvent {
    data class onSearchQueryChange(val query: String): PokemonListingEvent()
}
