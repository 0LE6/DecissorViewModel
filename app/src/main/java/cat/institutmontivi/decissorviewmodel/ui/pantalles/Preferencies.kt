package cat.institutmontivi.decissorviewmodel.ui.pantalles


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun Preferencies ()
{
    var sliderTemps by remember { mutableFloatStateOf(0F) }
    var sliderMinimMaxim by remember { mutableStateOf(0..999) }
    var pregunta by remember { mutableStateOf("I ara què pregunto?") }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceVariant)
            .padding(24.dp))

    {
        Spacer(Modifier.height(24.dp))
        Text(text = "Pantalla de preferències",
            modifier = Modifier
                .fillMaxWidth(),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center)

        Divider(Modifier.fillMaxWidth())

        Card(modifier = Modifier.padding(16.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = MaterialTheme.colorScheme.onSurface))
        {
            Text(
                text = "Cara o creu",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Start
            )

            Divider(Modifier.fillMaxWidth())
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Temps de tirada en milisegons:",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Start
            )
            Row()
            {
                Slider(
                    modifier = Modifier.weight(8F),
                    value = sliderTemps.toFloat(),
                    onValueChange = {sliderTemps = it },
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                    ),
                    steps = 6,
                    valueRange = 0f..5000f
                )
                Text(text = sliderTemps.toInt().toString(), modifier= Modifier.weight(2F))
            }
        }
        Card(modifier = Modifier.padding(16.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = MaterialTheme.colorScheme.onSurface))
        {
            Text(
                text = "Tria un número",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Start
            )

            Divider(Modifier.fillMaxWidth())
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Mínim i màxim",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Start
            )
            Row()
            {
                RangeSlider(
                    modifier = Modifier.weight(8F),
                    value = (sliderMinimMaxim.start.toFloat().. sliderMinimMaxim.endInclusive.toFloat()),
                    onValueChange = {sliderMinimMaxim = (it.start.toInt()..it.endInclusive.toInt())},
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                    ),
                    valueRange = 0F..999F,
                    steps = 1000
                )
                Text(text = sliderMinimMaxim.start.toString() + " - " + sliderMinimMaxim.endInclusive.toString(), modifier= Modifier.weight(2F))
            }
            Spacer(Modifier.height(24.dp))

        }
        Card(modifier = Modifier.padding(16.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = MaterialTheme.colorScheme.onSurface))
        {
            Text(
                text = "Oracle",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Start
            )

            Divider(Modifier.fillMaxWidth())
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Pregunta per defecte",
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Start
            )
            TextField(value = pregunta,
                onValueChange = {pregunta=it},
                label = {Text("Escriu aqui la pregunta per defecte")}, singleLine = true, modifier = Modifier.fillMaxWidth())
        }
    }
}