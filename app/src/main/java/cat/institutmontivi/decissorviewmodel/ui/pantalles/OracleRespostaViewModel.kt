package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import cat.institutmontivi.decissorviewmodel.navegacio.ArgumentDeNavegacio

class OracleRespostaViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    // NOTE : savedStateHandle: SavedStateHandle --> para recuperar parametros pasados
    private val pregunta = savedStateHandle.get<String>(ArgumentDeNavegacio.IdPregunta.clau)?: "waba laba dubdub"
    var estat by mutableStateOf(OracleRespostaEstat())
        private set

    val respostes = listOf<String>("Sí",
        "No",
        "Pot ser",
        "No ho crec",
        "Segur que sí",
        "No ho veig gens clar",
        "Ni de conya",
        "Hi pots comptar",
        "I jo que sé")
    fun respon() {
        estat = estat.copy(respostes[(0..respostes.size-1).random()])
    }
    init {
        estat = estat.copy(pregunta = pregunta, resposta = "")
        //estat = estat.copy()
        respon()
    }
    data class OracleRespostaEstat(
        val pregunta: String = "",
        val resposta: String = ""
    )
}