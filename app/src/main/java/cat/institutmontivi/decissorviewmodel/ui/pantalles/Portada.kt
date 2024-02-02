package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontivi.decissorviewmodel.R

@Preview
@Composable
fun Portada (onClick:()->Unit = {})
{
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceVariant)
            .padding(48.dp),
    )
    {
        Image (
            painterResource(id = R.drawable.logo_vermell),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth)
        Spacer (Modifier.height(48.dp))
        Divider(color = MaterialTheme.colorScheme.onSecondaryContainer,modifier= Modifier.height(15.dp))
        Spacer (Modifier.weight(1F))
        Image(painterResource(id = R.drawable.decissor), contentDescription="Decissor")
        Spacer (Modifier.weight(1F))
        Text(text = "Decissor",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center)
        Spacer (Modifier.weight(1F))

    }
}