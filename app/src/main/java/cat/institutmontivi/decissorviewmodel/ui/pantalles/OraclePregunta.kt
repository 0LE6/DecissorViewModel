package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cat.institutmontivi.decissorviewmodel.R

@Preview
@Composable
fun OraclePregunta (onClick:(String)->Unit = {})
{

    var pregunta by remember {mutableStateOf("")}
    val actualitzaPregunta: (String) -> Unit = {text-> pregunta = text}
    Box(Modifier.fillMaxSize().paint(painterResource(id = R.drawable.oracle), contentScale = ContentScale.FillBounds)){
        OutlinedTextField(value = pregunta , onValueChange = {actualitzaPregunta(it)}, Modifier.align(Alignment.CenterEnd),
            label = { Text("Escriu la teva pregunta") })
        Boto (Modifier.align(Alignment.BottomCenter),text = "Respon", clic ={onClick(if (pregunta.isNullOrEmpty())"" else pregunta)} )
    }
}