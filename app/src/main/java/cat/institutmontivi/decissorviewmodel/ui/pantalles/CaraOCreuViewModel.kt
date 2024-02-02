package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel // NOTE : importante para el concepto de ciclo de vida
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CaraOCreuViewModel : ViewModel() {

    var estat by mutableStateOf(CaraOCreuEstat())
        private set

    init { // NOTE : inicializar

        estat = estat.copy(resultat = 0, temps = 2000)
    }

    fun sorteja(temps: Long) {

        estat = estat.copy(temps = temps)
        //estat = estat.copy(resultat = 0) // NOTE : hacemos una copia
        //Thread.sleep(estat.temps) // NOTE : se cambia por la línea de abajo
        // NOTE : básicamente para que cuando le de a sorteja no se traba y puedes abrir el drawer
        viewModelScope.launch {
            estat = estat.copy(resultat = 0)
            delay(estat.temps)
            estat = estat.copy(resultat = (1..2).random())
        }
        //estat = estat.copy(resultat = (1..2).random())
    }

    data class CaraOCreuEstat (
        val resultat: Int = 0,
        val temps: Long = 2000
    )

}