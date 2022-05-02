package com.example.pokemon.presentation.pokemon_listings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.capitalize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.data.remote.PokemonAPI.Companion.PAGE_SIZE
import com.example.pokemon.domain.models.PokemonListEntry
import com.example.pokemon.domain.repository.PokemonRepository
import com.example.pokemon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PokemonListingViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    private var curPage = 0

    var state by mutableStateOf(PokemonListState())

    init {
        getPokemonListings()
    }

    fun onEvent(event: PokemonListingEvent) {
        when(event) {
            is PokemonListingEvent.onSearchQueryChange -> {
                state = state.copy(searchQuery = event.query)
                getPokemonListings()
            }
        }
    }

    fun getPokemonListings(
        query: String = state.searchQuery.lowercase()
    ) {
        viewModelScope.launch {

            state = state.copy(isLoading = true)
            val result = repository.getPokemonList(PAGE_SIZE, curPage* PAGE_SIZE)

            when(result) {
                is Resource.Success -> {
                    state.endReached = curPage* PAGE_SIZE >= result.data!!.count
                    val pokemonEntries = result.data.results.mapIndexed{index, entry ->
                        val number = if (entry.url.endsWith("/")) {
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }
                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
                        PokemonListEntry(entry.name.capitalize(Locale.ROOT), url, number.toInt())
                    }
                    curPage++
                    state = state.copy(
                        loadError = "",
                        isLoading = false,
                        pokemonsList = state.pokemonsList+pokemonEntries)
                }
                is Resource.Error -> {
                    state = state.copy(
                        loadError = result.message!!,
                        isLoading = false)

                }
            }
        }
    }
}