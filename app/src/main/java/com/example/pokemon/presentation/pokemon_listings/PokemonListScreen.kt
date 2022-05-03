package com.example.pokemon.presentation.pokemon_listings

import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokemon.R
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListingViewModel = hiltViewModel()
) {
    var state = viewModel.state
//   Surface(
//       color = MaterialTheme.colors.background,
//       modifier = Modifier.fillMaxSize()
//   ) {
//        Column {
//            Spacer(modifier = Modifier.height(20.dp))
//            Image(
//                painter = painterResource(id = R.drawable.poki_logo),
//                contentDescription = "Pokemon",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(CenterHorizontally)
//                )
//            SearchBar(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                hint = "Search...",
//                text = state.searchQuery
//            ) {
//
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            PokemonList(navController = navController)
//
//        }
//   }

    BackdropScaffold(
        scaffoldState = rememberBackdropScaffoldState(
            initialValue = BackdropValue.Concealed,
            animationSpec = spring(stiffness = 400f)),
        appBar = {

            Column(modifier = Modifier.fillMaxWidth()) {
//                Image(
//                    painter = painterResource(id = R.mipmap.pokeball),
//                    contentDescription = "Pokemon",
//                    modifier = Modifier
//                        .align(CenterHorizontally)
//                )


            }

        },

        frontLayerElevation = 30.dp,
        stickyFrontLayer = true,
        peekHeight = 70.dp,
        gesturesEnabled = false,
        frontLayerContent = {
            
            Column {
                Spacer(modifier = Modifier.height(20.dp))

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
        },
        backLayerContent = {
            Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.pokeball),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        fontSize = 22.sp,
                        color = Color.White,
                        text = "Pokemon",
                        fontWeight = FontWeight.Bold,
                    )

                }
        }
    ) {
        
    }
}