package com.panierdantan.screens.commercant.shops.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonAjoutProduit(onClickAjoutProduit: () -> Unit, text: String, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            modifier = Modifier.padding(0.dp),
            onClick = { onClickAjoutProduit() },
            colors = ButtonDefaults.buttonColors(Color(0xff85FDFF)),
            shape = RoundedCornerShape(100.dp)
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 20.dp, top = 5.dp, bottom = 5.dp, end = 20.dp)
            )
        }
    }

}