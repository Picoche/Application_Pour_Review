package com.panierdantan.screens.commercant.shops.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color.Companion.White

@Composable
fun ButtonAdd(onClickAdd: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize().padding(top=50.dp),
        contentAlignment = Alignment.Center
    ) {
        // Cercle bleu autour du bouton
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color(0xff336699)),
            contentAlignment = Alignment.Center
        ) {
            // Bouton bleu
            Button(
                onClick = { onClickAdd() },
                modifier = Modifier.size(75.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = White),
                shape = CircleShape
            ) {
                Text(
                    text = "+",
                    color = Color(0xff336699),
                    fontSize = 30.sp
                )
            }
        }
    }
}

