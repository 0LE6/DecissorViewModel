package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontivi.decissorviewmodel.R
import androidx.lifecycle.viewmodel.compose.viewModel
@Preview
@Composable
fun CaraOCreu (viewModel: CaraOCreuViewModel = viewModel())
{
    var resultat by remember { mutableStateOf(0) }
    Column(
        Modifier
            .padding(32.dp)
            .fillMaxSize())
    {
        var imatge = 0
        if (resultat == 0)
        {
            imatge =  R.drawable.question
        }
        else if (resultat == 1)
        {
            imatge = R.drawable.cara
        }
        else if (resultat == 2)
        {
            imatge = R.drawable.creu
        }
        Image(painter = painterResource(id = imatge), contentDescription = null,
            modifier = Modifier
                .weight(5f)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally), contentScale = ContentScale.Fit)
        Boto (
            Modifier
                .weight(0.75F)
                .fillMaxHeight(), "Sorteja de nou", {resultat = ((1..2).random())})
    }
}
@Composable
fun Boto (modifier: Modifier = Modifier, text: String = "", clic: ()->Unit)
{
    OutlinedButton(
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        onClick = clic,
        shape = RoundedCornerShape(28.dp),
        modifier = modifier,
        contentPadding = PaddingValues(15.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(alignment = Alignment.CenterVertically) )
        {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )
        }

    }
}