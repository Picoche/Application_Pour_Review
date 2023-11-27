package com.panierdantan.screens.commercant.shops

import BoutonActionFlotant
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.panierdantan.R
import com.panierdantan.screens.robotoFamily

@Composable
fun DetailBoutiquesView(onClick: () -> Unit, onClickQrCode:() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize().background(Color(0xff336699))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            // Image à gauche
                            Image(
                                painter = painterResource(id = R.drawable.boutique),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start= 10.dp,top=10.dp,bottom=10.dp)
                                    .height(170.dp)
                                    .width(100.dp)
                                    .clip(RoundedCornerShape(8.dp)) // Arrondir les coins de l'image
                                    .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                            )

                            // Texte à droite dans une colonne
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "Boucherie Maison Raymond",
                                    textAlign = TextAlign.Center,
                                    fontFamily = unboundedFamily,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xffffffff),
                                    fontSize = 18.sp
                                )
                                Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxSize().padding(end = 10.dp)) {
                                    Text(
                                        text = "12 rue François Thomières",
                                        textAlign = TextAlign.Justify,
                                        fontFamily = robotoFamily,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xffffffff),
                                        fontSize = 16.sp
                                    )

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Phone, // Icône de téléphone
                                            contentDescription = "Icon phone",
                                            tint = Color.White
                                        )
                                        Text(
                                            text = "05 63 72 62 80",
                                            textAlign = TextAlign.End,
                                            fontFamily = robotoFamily,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            fontSize = 14.sp,
                                            modifier = Modifier.padding(start = 4.dp) // Ajoute un espacement entre l'icône et le texte
                                        )
                                    }
                                    Text(
                                        text = "ouvert du lundi au samedi",
                                        textAlign = TextAlign.End,
                                        fontFamily = robotoFamily,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xffffffff),
                                        fontSize = 14.sp
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
                                            Text(
                                                text = "13",
                                                color = Color.White,
                                                modifier = Modifier.align(Alignment.Center)

                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(1.dp)
                                .size(28.dp)
                                .border(1.dp, Color.White, shape = CircleShape)

                        ) {
                            IconButton(
                                onClick = {
                                    onClick()
                                },
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(20.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                    }
                }
                Box(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 0.dp)){
                    BoutonActionFlotant("Scanner un QR code", onClickQrCode)
                }
            }
        }
    }
}