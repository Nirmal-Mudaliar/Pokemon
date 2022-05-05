package com.example.pokemon.domain.repository

import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.domain.models.PokemonListEntry
import com.example.pokemon.util.Resource

interface PokemonRepository {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Resource<PokemonList>

    suspend fun getPokemonInfo(
        pokemonName: String
    ): Resource<Pokemon>
}