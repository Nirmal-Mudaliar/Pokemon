package com.example.pokemon.presentation.pokemon_listings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonList(
    navController: NavController,
    viewModel: PokemonListingViewModel = hiltViewModel()
) {
    var state = viewModel.state
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        cells = GridCells.Fixed(2)
    ) {

        val itemCount = state.pokemonsList.size
        items(itemCount) {
            if (it >= itemCount-1 && !state.endReached && !state.isLoading && !state.isSearching) {
                viewModel.getPokemonListings()
            }
           PokemonEntery(entery = state.pokemonsList[it],
               navController = navController,
           )
        }
//        val itemCount = if (state.pokemonsList.size%2 == 0) {
//            state.pokemonsList.size/2
//        }else {
//            state.pokemonsList.size/2 + 1
//        }
//        items(itemCount) {
//            if (it >= itemCount-1 && !state.endReached) {
//                viewModel.getPokemonListings()
//            }
//            PokemonRow(rowIndex = it, entries = state.pokemonsList, navController = navController)
//        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if (state.loadError.isNotEmpty()) {
            RetrySection(error = state.loadError) {
                viewModel.getPokemonListings()
            }
        }
    }
}