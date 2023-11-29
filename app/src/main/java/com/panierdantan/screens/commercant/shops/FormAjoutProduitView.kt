package com.panierdantan.screens.commercant.shops

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.panierdantan.R
import com.panierdantan.components.Titre
import com.panierdantan.components.forms.ButtonForm
import com.panierdantan.components.forms.ListForm
import com.panierdantan.components.forms.PrixKgForm
import com.panierdantan.components.forms.QuantiteForm
import com.panierdantan.components.forms.SelectChoixForm
import com.panierdantan.components.forms.TextForm

@Composable
fun FormAjoutProduitView(onClick:() -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titre("Ajout d'un produit")
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
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            contentAlignment = Alignment.TopEnd,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.produit),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .height(120.dp)
                                    .width(150.dp)
                                    .clip(RoundedCornerShape(8.dp)) // Arrondir les coins de l'image
                                    .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                            )

                            IconButton(
                                onClick = { /* Action à exécuter lorsque le bouton est cliqué */ },
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color(0xFF336699), shape = CircleShape)
                                    .padding(4.dp)
                                    .align(Alignment.TopEnd)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Create,
                                    contentDescription = "Edit",
                                    tint = Color.White
                                )
                            }
                        }
                    }
                }
                item {
                    TextForm("Nom du produit")
                }
                item{
                    ListForm(label = "Type de produits", options = listOf("Boeuf", "Agneau", "Veau"))
                }
                item{
                    QuantiteForm("Quantité disponible")
                }
                item{
                    QuantiteForm("Prix au kg (€)")
                }
                item{
                   SelectChoixForm("Labels")
                }
                item {
                    ButtonForm(onClick, "Créer")
                }
            }
        }
    }
}