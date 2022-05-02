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
    val state = viewModel.state
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

            OutlinedTextField(
                value = state.searchQuery,
                onValueChange = {
                    // viewModel.onEvent(CompanyListingsEvent.OnSearchQueryChange(it))
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text(text = "Search...", color = MaterialTheme.colors.onBackground)
                },
                maxLines = 1,
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "SearchIcon")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        // viewModel.onEvent(CompanyListingsEvent.TextToSpeech)
                    }) {
                        Icon(imageVector = Icons.Filled.Mic, contentDescription = "SearchIcon")
                    }

                }
            )

        }
   }
}