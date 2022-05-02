package com.example.pokemon.presentation.pokemon_listings

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
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
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        cells = GridCells.Fixed(2)
    ) {

        val itemCount = state.pokemonsList.size
        items(itemCount) {
            if (it >= itemCount-1 && !state.endReached) {
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
}