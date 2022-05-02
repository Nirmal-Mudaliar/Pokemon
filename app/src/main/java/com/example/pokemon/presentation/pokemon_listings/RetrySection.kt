package com.example.pokemon.presentation.pokemon_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.R

@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit,

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painterResource(id = R.drawable.network_error),
            contentDescription = "Network error",
            modifier = Modifier.align(CenterHorizontally))
        //Text(text = error, color = Color.Red, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = { onRetry() },
            modifier = Modifier
                .fillMaxWidth()
                .height(78.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(80.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        ) {
            Text(text = "RETRY")
        }

    }

}