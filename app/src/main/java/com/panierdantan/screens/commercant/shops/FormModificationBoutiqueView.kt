package com.panierdantan.screens.commercant.shops

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.panierdantan.components.Titre
import com.panierdantan.components.forms.TextForm

@Composable
fun FormModificationBoutiqueView () {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titre("Détails du commerce")
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                item {
                    TextForm("Nom du produit")
                }
                item {
                    Spacer(modifier = Modifier.height(50.dp))
                    //ButtonForm(onClick, "Créer")
                }
            }
        }
    }
}