package com.panierdantan.screens.user.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardProduitClient(onClickProduit: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        onClick = {onClickProduit()}
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(5.dp)
        ) {
            // Image sur la gauche de la carte
            Image(
                painter = painterResource(id = com.panierdantan.R.drawable.produit),
                contentDescription = "Image",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            // Contenu à droite de l'image
            Column(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Boeuf",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "15€/kg",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row {
                    repeat(5) {
                        // Icônes d'étoiles
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xffff9914), // Couleur de l'étoile (jaune par exemple)
                            modifier = Modifier.size(10.dp) // Taille de l'étoile
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                Column(

                ) {
                    Row() {
                        repeat(2) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(android.graphics.Color.parseColor("#336699")),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .padding(horizontal = 8.dp)
                            ) {
                                Text(
                                    text = "bio",
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                        }
                    }


                }
            }
        }

    }
}
