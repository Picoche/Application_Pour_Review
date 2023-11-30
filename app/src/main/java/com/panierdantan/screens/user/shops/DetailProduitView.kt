package com.panierdantan.screens.user.shops

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import com.panierdantan.R
import com.panierdantan.components.forms.QuantiteForm
import com.panierdantan.screens.commercant.shops.components.ButtonAjoutProduit
import com.panierdantan.screens.commercant.shops.components.InfoBoutique
import com.panierdantan.screens.commercant.shops.components.MesProduits
import com.panierdantan.screens.commercant.shops.unboundedFamily
import com.panierdantan.screens.user.components.ButtonAjoutPanier

@Composable
fun DetailProduitView(onClickAjoutPanier: () -> Unit) {
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
                    .weight(0.5f)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    // Image sur la gauche de la carte
                    Image(
                        painter = painterResource(id = R.drawable.produit),
                        contentDescription = "Image",
                        modifier = Modifier
                            .height(150.dp)
                            .width(200.dp)
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
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            fontFamily = unboundedFamily,
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 4.dp)

                        )
                        Text(
                            text = "15€/kg",
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp), // Espace entre les étoiles
                            modifier = Modifier
                                .padding(10.dp)
                        ) {
                            repeat(5) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(0xffff9914), // Couleur de l'étoile (jaune par exemple)
                                    modifier = Modifier.size(24.dp) // Taille de l'étoile
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .size(30.dp) // Taille du cercle
                                    .background(Color(0xff336699), shape = CircleShape)
                                    .border(0.2.dp, Color.Gray, shape = RoundedCornerShape(100.dp))
                            ) {
                                androidx.compose.material3.Text(
                                    text = "13",
                                    color = Color.White,
                                    modifier = Modifier.align(Alignment.Center)

                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))

                        Column(

                        ) {
                            Row() {
                                repeat(3) {
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

            QuantiteForm(label = "Nombre de pièce")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp)
            ) {
                // Bouton pour afficher le calendrier
                Button(
                    onClick = { /* Logique pour afficher le calendrier */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                ) {
                    Text(text = "Choisir une date")
                }

                // Bouton pour afficher l'horloge
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                ) {
                    Text(text = "Choisir une heure")
                }
            }
            Box(modifier = Modifier.padding(bottom = 16.dp)) {
                ButtonAjoutPanier("Ajouter au panier", onClickAjoutPanier)
            }
        }
    }
}