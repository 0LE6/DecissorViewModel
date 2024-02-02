package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OracleRespostaViewModel : ViewModel() {

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
        estat = estat.copy()
    }
    data class OracleRespostaEstat(
        val resposta: String = ""
    )
}