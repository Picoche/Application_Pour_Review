package com.panierdantan.screens.commercant.shops

import BoutonActionFlotant
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.panierdantan.screens.commercant.shops.components.ButtonAjoutProduit
import com.panierdantan.screens.commercant.shops.components.InfoBoutique
import com.panierdantan.screens.commercant.shops.components.MesProduits

@Composable
fun DetailBoutiquesView(onClick: () -> Unit, onClickQrCode:() -> Unit, onClickAjoutProduit: () -> Unit, onClickModifBoutique:() -> Unit) {
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
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                InfoBoutique(onClick, onClickModifBoutique)
            }

            ButtonAjoutProduit(
                onClickAjoutProduit,
                text = "Ajout d'un Produit",
                modifier = Modifier
                    .padding(vertical = 2.dp) // Ajustement de la marge verticale
            )

            LazyVerticalGrid(
                GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(1.dp), // Réduction de l'espace entre les items
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                items(8) {
                    MesProduits()
                }
            }

            Box(modifier = Modifier.padding(bottom = 16.dp)) {
                BoutonActionFlotant("Scanner un QR code", onClickQrCode)
            }
        }
    }

}