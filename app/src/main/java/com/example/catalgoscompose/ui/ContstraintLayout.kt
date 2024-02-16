package com.example.catalgoscompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 *
 * Layouts
 * -Box
 * -Column
 * -Row
 * -ConstraintLayout
 *
 */
@PreviewScreenSizes
@Composable
fun MyConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        val (boxRed, boxMagenta, boxGreen, boxBlue, boxYellow) = createRefs()
        val guideHorizontal= createGuidelineFromTop(0.2f)
        val barrierTop = createBottomBarrier(boxMagenta,boxGreen)

        val barrierVertical = createEndBarrier(boxMagenta,boxBlue )
        val guideVertical = createGuidelineFromEnd(0.8f)

        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    //top.linkTo(guideHorizontal)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(guideHorizontal)
                }
        )

        Box(modifier = Modifier
            .size(25.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                top.linkTo(boxRed.bottom)

                end.linkTo(boxRed.start)
            } )

        Box(modifier = Modifier
            .size(12.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxMagenta.top)
                end.linkTo(parent.end)
            } )

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(barrierTop)
            } )
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(barrierVertical)
                end.linkTo(guideVertical)
            } )
    }
}