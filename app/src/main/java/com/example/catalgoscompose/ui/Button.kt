package com.example.catalgoscompose.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Label
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
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

@Composable
fun MyButtonExample() {

    var text: String = ""
    var stateText by remember { mutableStateOf("Vacio") }
    var stateEnable by remember { mutableStateOf(true) }
    var stateCounter by remember { mutableIntStateOf(0) }

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
            },
            modifier = Modifier

                .padding(20.dp)
                .height(60.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            enabled = stateEnable,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)/*ButtonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Cyan,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            )*/
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

@Preview
@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }
    var enable by rememberSaveable {
        mutableStateOf(true)
    }

    var belowState by rememberSaveable {
        mutableStateOf(true)
    }

    Column {
        Text(text = "Habilitar switch")
        Switch(checked = belowState, onCheckedChange = {
            run {
                belowState = !belowState
                enable = !enable
            }

        })

        Switch(enabled = enable,
            checked = state,
            onCheckedChange = { state = !state },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedTrackColor = Color.White,
                checkedBorderColor = Color.Gray,

                uncheckedThumbColor = Color.DarkGray,
                uncheckedTrackColor = Color.Gray,
                uncheckedBorderColor = Color.Transparent,

                disabledCheckedThumbColor = Color(0xFFB000FC),
                disabledCheckedTrackColor = Color(0x3CDC3CFC),
                disabledCheckedBorderColor = Color.Transparent,

                disabledUncheckedThumbColor = Color(0xFFFFDC00),
                disabledUncheckedTrackColor = Color(0x17FFFF00),
                disabledUncheckedBorderColor = Color(0x4BFFFF00)

            ),
            thumbContent = {
                MyIcon()
            })
        Checkbox(
            enabled = enable,
            checked = state,
            onCheckedChange = { state = !state },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.DarkGray,
                checkmarkColor = Color.Green,

                uncheckedColor = Color.Black,

                disabledCheckedColor = Color.Gray,
                disabledUncheckedColor = Color.Black,
                disabledIndeterminateColor = Color.Green,
            )

        )

        MyTriState(text = "Pan", enable = enable)
        MyTriState(text = "Leche", enable = enable)
        MyTriState(text = "Huevos", enable = enable)
        MyTriState(text = "Carne", enable = enable)
        MyTriState(text = "Linaza", enable = enable)

        MyRadio(enable = enable, text ="Puerto Rico")

        MyRadio(text = "Canada", enable)
        MyRadio(text = "Perú", enable)
    }

}

@Composable
fun MyTriState(text: String, enable: Boolean) {
    var triState by rememberSaveable {
        mutableStateOf(ToggleableState.Indeterminate)
    }
    Row {
        TriStateCheckbox(
            enabled = enable,
            state = triState,
            onClick = {
                triState = when (triState) {
                    ToggleableState.Off -> ToggleableState.Indeterminate
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.DarkGray,
                checkmarkColor = Color.Green,

                uncheckedColor = Color.White,

                disabledCheckedColor = Color.Gray,
                disabledUncheckedColor = Color.Black,
                disabledIndeterminateColor = Color.Green,
            )

        )
        Text(text = text)
    }
}

@Composable
fun MyRadio(text: String = "Vacio", enable: Boolean = true) {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row {
        RadioButton(
            enabled = enable,
            selected = state, onClick = { state = !state }, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Blue,
                unselectedColor = Color.Red,
                disabledSelectedColor = Color.Cyan,
                disabledUnselectedColor = Color.Magenta
            )
        )
        Text(text = text)
    }
}