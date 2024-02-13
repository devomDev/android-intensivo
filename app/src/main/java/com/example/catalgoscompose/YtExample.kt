package com.example.catalgoscompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness1
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


@Preview()
@Composable
fun YtList() {
    YtCard(
        image = R.drawable.juanci,
        totalTime = "52:02",
        icon = R.drawable.juanci,
        title = "Episodio 5 - Juan Cirerol | Diamante en el mapa",
        channel = "enummastudios",
        views = "73 k vistas",
        uploadTime = "Hace 1 mes"
    )

}

@Composable
fun YtCard(
    image: Int,
    totalTime: String,
    icon: Int,
    title: String,
    channel: String,
    views: String,
    uploadTime: String
) {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.background(color = Color.Black)) {
            //CardTop
            ConstraintLayout(modifier = Modifier) {
                val (imgBox, timeBox, onlyBox) = createRefs()
                val guideLineVertical = createGuidelineFromBottom(0.5f)
                val guideLineHorizontal = createGuidelineFromEnd(0.1f)

                Box(modifier = Modifier.constrainAs(imgBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }) {
                    Image(
                        painter = painterResource(image), contentDescription = "imagen componente"
                    )
                }

                Box(modifier = Modifier
                    .padding(6.dp)
                    .constrainAs(timeBox) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }) {
                    Text(
                        text = totalTime,
                        modifier = Modifier
                            .padding(1.dp)
                            .background(
                                color = Color.Black, shape = RoundedCornerShape(2.dp)
                            ),
                        color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Bold,
                    )
                }

                Box(
                    Modifier
                        .size(100.dp)
                        .background(color = Color.Green)
                        .constrainAs(onlyBox) {
                            top.linkTo(guideLineVertical)
                            start.linkTo(guideLineHorizontal)

                        }) {
                    Text(text = "Mi caja roja", color = Color.Red)
                }
            }

            //Middle top
            Row(Modifier.size(width = 250.dp, height = 40.dp)) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape),
                    painter = painterResource(icon),
                    contentDescription = "imagen componente"
                )
                Text(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    text = title,
                )
            }
            Text(
                text = channel, fontSize = 10.sp
            )
            Row {
                Text(
                    text = views, fontSize = 10.sp
                )
                Icon(
                    imageVector = Icons.Filled.Brightness1,
                    modifier = Modifier
                        .size(6.dp)
                        .align(Alignment.CenterVertically),
                    contentDescription = ""
                )
                Text(
                    fontSize = 10.sp, text = uploadTime
                )
            }
        }
    }
}