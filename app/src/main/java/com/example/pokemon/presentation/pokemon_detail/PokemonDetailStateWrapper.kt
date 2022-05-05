package com.example.pokemon.presentation.pokemon_detail

import androidx.compose.foundation.layout.offset
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.util.Resource

@Composable
fun PokemonDetailStateWrapper(
    pokemonInfo: Resource<Pokemon>,
    modifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier
) {
    when(pokemonInfo) {
        is Resource.Success -> {
            PokemonDetailSection(pokemonInfo = pokemonInfo.data!!,
            modifier = modifier
                .offset(y = (-20).dp))
        }
        is Resource.Error -> {
            Text(text = pokemonInfo.message!!,
            color = Color.Red,
            modifier = modifier)
        }
        is Resource.Loading -> {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                modifier = loadingModifier
            )
        }
    }
}