package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import cat.institutmontivi.decissorviewmodel.R

@Preview
@Composable
fun OracleResposta (pregunta:String="")
{
    val respostes = listOf<String>("Sí",
        "No",
        "Pot ser",
        "No ho crec",
        "Segur que sí",
        "No ho veig gens clar",
        "Ni de conya",
        "Hi pots comptar",
        "I jo que sé")
    Box(
        Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.oracle_resposta),
                contentScale = ContentScale.FillBounds
            )){
        Text(text = pregunta, Modifier.align(Alignment.TopCenter), style = MaterialTheme.typography.displaySmall)

        Text(text = respostes[(0..respostes.size-1).random()], Modifier.align(Alignment.BottomCenter), style = MaterialTheme.typography.displayMedium)
    }
}