package cat.institutmontivi.decissorviewmodel.navegacio

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument


enum class CategoriaDeNavegacio(
    val rutaPrevia: String,
    val icona: ImageVector,
    val titol: String
){
    Portada ("Portada", Icons.Default.Home, "Portada"),
    CaraOCreu("CaraOCreu", Icons.Default.AddCircle,"Cara o creu"),
    Numero("Numero", Icons.Default.Create,"Número"),
    Oracle("Oracle", Icons.Default.Face,"Pregunta"),
    Preferencies ("Preferencies", Icons.Default.Build, "Preferencies"),
    Instruccions ("Instruccions", Icons.Default.Info, "Instruccions"),
    QuantA ("QuantA", Icons.Default.Face, "Quant a...")
}
sealed class Destinacio(
    val rutaBase: String,
    val argumentsDeNavegacio: List <ArgumentDeNavegacio> = emptyList()
)
{

    val navArgs = argumentsDeNavegacio.map { it.toNavArgument()}
    /**
     * Propietat que crea l'string amb la ruta base i tots els arguments separats per barres
     */
    val rutaGenerica = run {
        //cal construir un string tipus: rutabase/{arg1}/{arg2} ...
        val clausArguments = argumentsDeNavegacio.map{"{${it.clau}}"}
        listOf(rutaBase)
            .plus(clausArguments)
            .joinToString("/")
    }

    object Portada: Destinacio(CategoriaDeNavegacio.Portada.rutaPrevia+"/Inici")
    object Preferencies: Destinacio(CategoriaDeNavegacio.Preferencies.rutaPrevia+"/Inici")
    object Instruccions: Destinacio(CategoriaDeNavegacio.Instruccions.rutaPrevia+"/Inici")
    object QuantA: Destinacio(CategoriaDeNavegacio.QuantA.rutaPrevia+"/Inici")
    object CaraOCreu:Destinacio(CategoriaDeNavegacio.CaraOCreu.rutaPrevia+"/Inici")
    object Numero:Destinacio(CategoriaDeNavegacio.Numero.rutaPrevia+"/Inici")
    object OraclePregunta:Destinacio(CategoriaDeNavegacio.Oracle.rutaPrevia+"/Inici")
    object OracleResposta:Destinacio(CategoriaDeNavegacio.Oracle.rutaPrevia+"/Resposta",listOf(ArgumentDeNavegacio.IdPregunta)) {
        fun CreaRutaAmbArguments(idPregunta: String) = if (idPregunta.isNullOrEmpty()) "$rutaBase/ " else "$rutaBase/$idPregunta"
        // Cal mirar si es null or empty perquè si no posa res després de la / dóna error de navegació
    }

}

//NavType<*> ens permet identificar qualsevol tipus de NavType
enum class ArgumentDeNavegacio (val clau: String, val tipus: NavType<*>){
    IdTemps("IdTemps", NavType.LongType),
    IdMinim("IdMinim", NavType.IntType),
    IdMaxim("IdMaxim", NavType.IntType),
    IdPregunta("IdPregunta", NavType.StringType);

    fun toNavArgument (): NamedNavArgument {
        return navArgument(clau) {type = tipus}
    }
}
