package com.example.pokemon.data.maper

import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.data.remote.responses.Result
import com.example.pokemon.domain.models.PokemonListEntry

fun PokemonList.toPokemonListEntry():PokemonListEntry {
    return PokemonListEntry(
        pokemonName = results.component1().name ?: "",
        url = results.component1().url ?: "",
        number = count,


    )
}