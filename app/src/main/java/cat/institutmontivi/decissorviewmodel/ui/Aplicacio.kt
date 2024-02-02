package cat.institutmontivi.decissorviewmodel.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.institutmontivi.decissorviewmodel.R
import cat.institutmontivi.decissorviewmodel.navegacio.CategoriaDeNavegacio
import cat.institutmontivi.decissorviewmodel.navegacio.Destinacio
import cat.institutmontivi.decissorviewmodel.navegacio.GrafDeNavegacio
import cat.institutmontivi.decissorviewmodel.ui.theme.DecissorViewModelTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PantallaDeLAplicacio (content: @Composable ()->Unit)
{
    DecissorViewModelTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Aplicacio (content: @Composable ()-> Unit = {Text ("")})
{
    val controladorDeNavegacio = rememberNavController()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    var estatDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navBackStackEntry by controladorDeNavegacio.currentBackStackEntryAsState()
    val rutaActual = navBackStackEntry?.destination?.route ?: ""

    Bastida(controladorDeNavegacio,coroutineScope, estatDrawer, rutaActual)
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bastida(
    controladorDeNavegacio: NavHostController,
    coroutineScope: CoroutineScope,
    estatDrawer: DrawerState,
    rutaActual: String
)
{
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Decissor") },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    if(rutaActual in listOf(
                            Destinacio.Portada.rutaGenerica,
                            Destinacio.Instruccions.rutaGenerica,
                            Destinacio.Preferencies.rutaGenerica,
                            Destinacio.QuantA.rutaGenerica,
                            Destinacio.CaraOCreu.rutaGenerica,
                            Destinacio.Numero.rutaGenerica,
                            Destinacio.OraclePregunta.rutaGenerica)) {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                if (estatDrawer.isClosed)
                                    estatDrawer.open()
                                else
                                    estatDrawer.close()
                            }
                        }) {

                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                    else{
                        IconButton(onClick = { controladorDeNavegacio.navigateUp()}) {

                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                })
        }

    )
    {paddingValues ->
        Drawer(controladorDeNavegacio,coroutineScope, estatDrawer, Modifier.padding(paddingValues), rutaActual)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Drawer(
    controladorDeNavegacio: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    estatDrawer: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    modifier: Modifier,
    rutaActual: String
) {
    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = estatDrawer,
        drawerContent = {
            ModalDrawerSheet (
                drawerShape = ShapeDefaults.Small, //fa referència a la mida del corner radius
                drawerContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                drawerContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                drawerTonalElevation = 5.dp,
                windowInsets = WindowInsets(left = 24.dp, right = 24.dp, top = 48.dp) // És el padding
            ){
                Image (
                    painterResource(id = R.drawable.logo_blau),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth)
                Spacer (Modifier.height(48.dp))
                Divider(color = MaterialTheme.colorScheme.onSecondaryContainer,modifier= Modifier.height(15.dp))
                Spacer (Modifier.height(48.dp))
                CategoriaDeNavegacio.values().forEach {
                    NavigationDrawerItem  (
                        label = { Text(it.titol) },
                        selected = rutaActual.contains(it.rutaPrevia),
                        icon = {Icon (imageVector = it.icona, it.titol)},
                        onClick = {
                            coroutineScope.launch {
                                estatDrawer.close()
                            }
                            controladorDeNavegacio.navigate(it.rutaPrevia) {
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id){
                                    //guarda l'estat de la pantalla de la que marxem (funciona d'aquella manera,
                                    // No tots els valors es guarden))
                                    saveState = true
                                }
                                launchSingleTop = true
                                //Restaura l'estat de la pantalla i la deixa tal i com estava quan vam navegar a un altre lloc
                                restoreState = true
                            }  },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedBadgeColor = MaterialTheme.colorScheme.error,
                            unselectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            selectedBadgeColor = MaterialTheme.colorScheme.error,
                            selectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                            selectedIconColor = MaterialTheme.colorScheme.onTertiaryContainer,
                            selectedTextColor = MaterialTheme.colorScheme.onTertiaryContainer),
                        //badge = {Icon(imageVector = Icons.Default.ArrowBack, null)},
                        shape = ShapeDefaults.Medium
                    )
                }
            }
        },
        gesturesEnabled = rutaActual in listOf(
            Destinacio.Portada.rutaGenerica,
            Destinacio.Instruccions.rutaGenerica,
            Destinacio.Preferencies.rutaGenerica,
            Destinacio.QuantA.rutaGenerica,
            Destinacio.CaraOCreu.rutaGenerica,
            Destinacio.Numero.rutaGenerica,
            Destinacio.OraclePregunta.rutaGenerica)
    ) {
        GrafDeNavegacio(controladorDeNavegacio)
    }
}