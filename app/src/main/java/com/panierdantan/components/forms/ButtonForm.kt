package com.panierdantan.components.forms

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
fun ButtonForm(onClick: () -> Unit, text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(Color(0xff85FDFF)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
        }
    }

}