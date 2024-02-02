package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OracleRespostaViewModel : ViewModel() {

    var estat by mutableStateOf(OracleRespostaEstat())
        private set

    init {
        estat = estat.copy()
    }
    data class OracleRespostaEstat(
        val resposta: String = ""
    )
}