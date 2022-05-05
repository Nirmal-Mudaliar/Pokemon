package com.example.pokemon.util


import androidx.compose.ui.graphics.Color
import com.example.pokemon.data.remote.responses.Stat
import com.example.pokemon.data.remote.responses.Type
import com.example.pokemon.ui.theme.*
import java.util.Locale.ROOT

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.toLowerCase(ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special_attack" -> SpAtkColor
        "special_defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special_attack" -> "SpAtk"
        "special_defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}