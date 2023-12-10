package com.panierdantan.screens.commercant.shops

import BoutonActionFlotant
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.panierdantan.R
import com.panierdantan.screens.commercant.shops.components.ButtonAdd
import com.panierdantan.screens.commercant.shops.components.CardBoutique
import com.panierdantan.components.Titre
import com.panierdantan.view_models.DataViewModel

val unboundedFamily = FontFamily(
    Font(R.font.unbounded_light, FontWeight.Light),
    Font(R.font.unbounded_regular, FontWeight.Normal),
    Font(R.font.unbounded_medium, FontWeight.Medium),
    Font(R.font.unbounded_bold, FontWeight.Bold)
)

@Composable
fun MesBoutiquesView(onClickAdd: () -> Unit, onClickBoutique:() -> Unit, onClickQrCode:()-> Unit, dataViewModel: DataViewModel) {
    val shops by dataViewModel.shops.collectAsStateWithLifecycle()
    Log.d("shops", shops.toString())
    LaunchedEffect(key1 = true) {
        dataViewModel.getShops()
    }
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
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 0.dp)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(shops.size) {
                        val boutique = shops.elementAt(it)
                        CardBoutique(onClickBoutique, boutique)
                    }
                    item {
                        ButtonAdd(onClickAdd)
                        Spacer(modifier = Modifier.padding(bottom = 70.dp))
                    }
                }
                Box(modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 0.dp)){
                    BoutonActionFlotant("Scanner un QR code", onClickQrCode)
                }
            }
        }
    }
}