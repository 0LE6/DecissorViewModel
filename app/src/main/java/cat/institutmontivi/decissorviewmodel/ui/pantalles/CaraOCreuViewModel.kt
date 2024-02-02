package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.lifecycle.ViewModel // NOTE : importante para el concepto de ciclo de vida

class CaraOCreuViewModel : ViewModel() {

    data class CaraOCreuEstat (
        val resultat: Int = 0,
        val temps: Long = 1000
    )

}