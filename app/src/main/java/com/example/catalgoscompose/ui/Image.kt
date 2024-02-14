package com.example.catalgoscompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.twotone.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.catalgoscompose.R

@Composable
fun MyImagePainter() {
    Image(
        painter = painterResource(id = R.drawable.juanci),

        contentDescription = "image",
        modifier = Modifier.clip(
            CircleShape
        ).border(5.dp, Color.White, CircleShape).size(360.dp),
        contentScale = ContentScale.Crop,

    )
}

@Composable
fun MyImageVector() {
    Image(imageVector = Icons.TwoTone.Image, contentDescription = "Icon")
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Person, contentDescription = "icon person")
}