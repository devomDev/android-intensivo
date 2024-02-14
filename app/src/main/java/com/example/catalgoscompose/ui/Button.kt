package com.example.catalgoscompose.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TooltipBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupPositionProvider
import com.example.catalgoscompose.R

@Preview
@Composable
fun MyButtonExample() {

    var text: String = ""
    var stateText by remember { mutableStateOf("Vacio") }
    var stateEnable by remember { mutableStateOf(true) }
    var stateCounter by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
    ) {
        MyTextField()
        OutlinedButton(
            onClick = {
                stateCounter++
                stateText = when {
                    stateText.contains("Vacio") -> {
                        "Un Click"
                    }

                    stateText.contains("Un") -> {
                        "Dos Clicks"
                    }

                    else -> {
                        "Vacio"
                    }
                }
                if (stateCounter == 5) {
                    stateEnable = false
                }
                execFunc()
            },
            modifier = Modifier

                .padding(20.dp)
                .height(60.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            enabled = stateEnable,
            colors = ButtonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Cyan,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            )
        ) {
            Column {
                Badge {
                    Text(text = "Info")
                }
                //TooltipBox(positionProvider = , tooltip = , state = ) {

            }
            Text(
                text = "Hola mundo",
                modifier = Modifier,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Green,
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Red
                )
            )
            Text(text = stateText)
        }

        MyImagePainter()
    }
}

@Composable
fun MyTextField() {
    var stateText by remember {
        mutableStateOf("default")
    }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        value = stateText,
        onValueChange = { stateText = it },
        textStyle = TextStyle(color = Color.Green, background = Color.Blue)
    )

    TextButton(onClick = { /*TODO*/ }) {

    }

}

fun execFunc() {
    Log.d("Botón", "Hola mundo")
}
