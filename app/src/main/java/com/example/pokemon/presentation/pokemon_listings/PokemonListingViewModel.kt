package com.example.pokemon.presentation.pokemon_listings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListingViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {
    var state by mutableStateOf(PokemonListState())
    init {
        getPokemonListings()
    }

    fun getPokemonListings(
        query: String = state.searchQuery.lowercase()
    ) {
        viewModelScope.launch {
            //repository.getPokemonList()
        }
    }
}