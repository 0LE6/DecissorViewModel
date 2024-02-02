package cat.institutmontivi.decissorviewmodel.navegacio

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import cat.institutmontivi.decissorviewmodel.ui.pantalles.CaraOCreu
import cat.institutmontivi.decissorviewmodel.ui.pantalles.Instruccions
import cat.institutmontivi.decissorviewmodel.ui.pantalles.OraclePregunta
import cat.institutmontivi.decissorviewmodel.ui.pantalles.OracleResposta
import cat.institutmontivi.decissorviewmodel.ui.pantalles.Portada
import cat.institutmontivi.decissorviewmodel.ui.pantalles.Preferencies
import cat.institutmontivi.decissorviewmodel.ui.pantalles.QuantA
import cat.institutmontivi.decissorviewmodel.ui.pantalles.TriaUnNumero


@Composable
fun GrafDeNavegacio (controladorDeNavegacio: NavHostController = rememberNavController())
{
    NavHost(navController = controladorDeNavegacio, startDestination =CategoriaDeNavegacio.Portada.rutaPrevia)
    {
        navigation(startDestination = Destinacio.Portada.rutaBase,route =CategoriaDeNavegacio.Portada.rutaPrevia )
        {
            composable(route = Destinacio.Portada.rutaGenerica){
                Portada()
            }
        }

        navigation(startDestination = Destinacio.Instruccions.rutaBase,route =CategoriaDeNavegacio.Instruccions.rutaPrevia )
        {
            composable(route = Destinacio.Instruccions.rutaGenerica){
                Instruccions()
            }
        }
        navigation(startDestination = Destinacio.Preferencies.rutaBase,route =CategoriaDeNavegacio.Preferencies.rutaPrevia)
        {
            composable(route = Destinacio.Preferencies.rutaGenerica){
                Preferencies()
            }
        }
        navigation(startDestination = Destinacio.QuantA.rutaBase,route =CategoriaDeNavegacio.QuantA.rutaPrevia)
        {
            composable(route = Destinacio.QuantA.rutaGenerica){
                QuantA()
            }
        }
        navigation(startDestination = Destinacio.CaraOCreu.rutaBase,route =CategoriaDeNavegacio.CaraOCreu.rutaPrevia)
        {
            composable(route = Destinacio.CaraOCreu.rutaGenerica){
                CaraOCreu()
            }
        }
        navigation(startDestination = Destinacio.Numero.rutaBase,route =CategoriaDeNavegacio.Numero.rutaPrevia)
        {
            composable(route = Destinacio.Numero.rutaGenerica){
                TriaUnNumero()
            }
        }
        navigation(startDestination = Destinacio.OraclePregunta.rutaBase,route =CategoriaDeNavegacio.Oracle.rutaPrevia)
        {
            composable(route = Destinacio.OraclePregunta.rutaGenerica){
                OraclePregunta(onClick = {pregunta:String -> controladorDeNavegacio.navigate(Destinacio.OracleResposta.CreaRutaAmbArguments(pregunta))})
            }
            composable (route = Destinacio.OracleResposta.rutaGenerica, arguments = Destinacio.OracleResposta.navArgs){
                val pregunta = it.arguments?.getString(ArgumentDeNavegacio.IdPregunta.clau) ?: ""
                requireNotNull(pregunta)
                OracleResposta(pregunta)
            }
        }
    }
}