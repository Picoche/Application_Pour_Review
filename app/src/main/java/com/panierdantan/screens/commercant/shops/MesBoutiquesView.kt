package com.panierdantan.screens.commercant.shops

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.panierdantan.R
import com.panierdantan.screens.commercant.shops.components.ButtonAdd
import com.panierdantan.screens.commercant.shops.components.CardBoutique
import com.panierdantan.components.Titre

val unboundedFamily = FontFamily(
    Font(R.font.unbounded_light, FontWeight.Light),
    Font(R.font.unbounded_regular, FontWeight.Normal),
    Font(R.font.unbounded_medium, FontWeight.Medium),
    Font(R.font.unbounded_bold, FontWeight.Bold)
)

@Composable
fun MesBoutiquesView(onClickAdd: () -> Unit, onClickBoutique:() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Titre("Mes Boutiques")
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(2) {
                        CardBoutique(onClickBoutique)
                    }
                    item {
                        ButtonAdd(onClickAdd)
                    }
                }
            }
        }
    }
}