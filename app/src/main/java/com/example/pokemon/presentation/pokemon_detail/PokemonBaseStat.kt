package com.example.pokemon.presentation.pokemon_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.util.parseStatToAbbr
import com.example.pokemon.util.parseStatToColor
import com.example.pokemon.util.parseTypeToColor

@Composable
fun PokemonBaseStat(
    pokemonInfo: Pokemon,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.stats.maxOf { it.base_stat }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Base stats:",
        fontSize = 20.sp,
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier.padding(top = 34.dp))
    }
    Spacer(modifier = Modifier.height(20.dp))
    for(i in pokemonInfo.stats.indices) {
        val stat = pokemonInfo.stats[i]
        PokemonStat(statName = parseStatToAbbr(stat),
            statValue = stat.base_stat,
            statMaxValue = maxBaseStat,
            statColor = parseStatToColor(stat),
            animDelay = i*animDelayPerItem
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}