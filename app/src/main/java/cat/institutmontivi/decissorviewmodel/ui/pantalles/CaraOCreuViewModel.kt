package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel // NOTE : importante para el concepto de ciclo de vida

class CaraOCreuViewModel : ViewModel() {

    var estat by mutableStateOf(CaraOCreuEstat())
        private set

    init { // NOTE : inicializar
        estat = estat.copy(resultat = 0, temps = 0)
    }
    data class CaraOCreuEstat (
        val resultat: Int = 0,
        val temps: Long = 1000
    )

}