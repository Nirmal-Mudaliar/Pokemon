package com.example.pokemon.data.remote

import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.data.remote.responses.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2"
    }
}