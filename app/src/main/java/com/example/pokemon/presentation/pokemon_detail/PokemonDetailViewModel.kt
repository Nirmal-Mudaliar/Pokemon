package com.example.pokemon.presentation.pokemon_detail

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.domain.repository.PokemonRepository
import com.example.pokemon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonDetailInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName = pokemonName)
    }
}