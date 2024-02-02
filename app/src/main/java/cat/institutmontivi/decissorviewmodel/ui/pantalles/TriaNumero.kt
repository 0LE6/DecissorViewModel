package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TriaUnNumero ()
{

    var minim by remember{ mutableStateOf(0) }
    var maxim by remember{ mutableStateOf(999) }
    var valorTriat by remember{ mutableStateOf(500) }
    Column(
        Modifier
            .padding(32.dp)
            .fillMaxSize())
    {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Text(
                text = ""+valorTriat, Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
        }
        Boto(text = "Sorteja un altre cop", clic = { valorTriat = (minim .. maxim).random() })
    }

}