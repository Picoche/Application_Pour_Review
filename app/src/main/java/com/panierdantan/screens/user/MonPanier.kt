package com.panierdantan.screens.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.panierdantan.screens.commercant.shops.components.MesProduits
import com.panierdantan.screens.user.components.CardProduitClient
import com.panierdantan.screens.user.components.InfoBoutiqueClient

@Composable
fun MonPanier(onClickProduit: () -> Unit) {
    //Ce code devra être positionné dans la partie client
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff336699))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .weight(0.5F)
                    .fillMaxWidth()
            ) {
                InfoBoutiqueClient()
            }
            LazyVerticalGrid(
                GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(1.dp), // Réduction de l'espace entre les items
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                items(16) {
                    CardProduitClient(onClickProduit)
                }
            }
        }
    }
}