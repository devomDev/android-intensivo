import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MySlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var position by rememberSaveable {
            mutableFloatStateOf(0f)
        }

        var finishedPosition by rememberSaveable {
            mutableStateOf("")
        }
        Slider(
            value = position,
            onValueChange = { position = it },
            onValueChangeFinished = { finishedPosition = position.toString() },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = position.toString())
    }
}

@Composable
fun MyBiSlider() {
    var currentRange by remember {
        mutableStateOf(0f..10f)
    }
    Column {
        RangeSlider(
            value = currentRange,
            onValueChange = {currentRange = it},
            valueRange =  0f..10f,
            steps = 9
        )

        Text(text = "Valor A => ${currentRange.start}")
        Text(text = "Valor B => ${currentRange.endInclusive}")
    }
}
