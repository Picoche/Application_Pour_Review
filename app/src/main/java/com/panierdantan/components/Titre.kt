package com.panierdantan.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.panierdantan.screens.commercant.shops.unboundedFamily

@Composable
fun Titre(text: String){
    Text(text = text,
        textAlign = TextAlign.Center,
        fontFamily = unboundedFamily,
        fontWeight = FontWeight.Black,
        color = Color(0xff336699),
        fontSize = 24.sp
        //modifier = Modifier.shadow(4.dp, shape = CircleShape, clip = true)
    )
}
