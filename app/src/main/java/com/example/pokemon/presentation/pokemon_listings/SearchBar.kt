package com.example.pokemon.presentation.pokemon_listings

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    text: String = "",
    viewModel : PokemonListingViewModel = hiltViewModel(),
    onSearch: (String) -> Unit = {}
){
    OutlinedTextField(
        value = text,
        onValueChange = {
            viewModel.onEvent(PokemonListingEvent.onSearchQueryChange(it))
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        placeholder = {
            Text(text = hint, color = MaterialTheme.colors.onBackground)
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