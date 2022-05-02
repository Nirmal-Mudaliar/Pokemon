package com.example.pokemon.presentation.pokemon_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokemon.R
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListingViewModel = hiltViewModel()
) {
    var state = viewModel.state
   Surface(
       color = MaterialTheme.colors.background,
       modifier = Modifier.fillMaxSize()
   ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.poki_logo),
                contentDescription = "Pokemon",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
                )
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth(),
                hint = "Search...",
                text = state.searchQuery
            ) {

            }
            Spacer(modifier = Modifier.height(16.dp))
            PokemonList(navController = navController)

        }
   }
}