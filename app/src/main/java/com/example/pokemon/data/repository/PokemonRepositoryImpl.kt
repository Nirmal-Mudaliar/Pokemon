package com.example.pokemon.data.repository

import com.example.pokemon.data.remote.PokemonAPI
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.domain.repository.PokemonRepository
import com.example.pokemon.util.Resource
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonAPI
): PokemonRepository{

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val respose = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(respose)
    }

}