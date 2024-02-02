package cat.institutmontivi.decissorviewmodel.ui.pantalles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TriaNumeroViewModel : ViewModel() {

    var estat by mutableStateOf(TriaNumeroEstat())
        private set

    init {
        estat = estat.copy(minim = 0, maxim = 999, valorTriat = 500)
    }

    fun sortejaNumero() {

        estat = estat.copy(valorTriat = (estat.minim..estat.maxim).random())
    }

    data class TriaNumeroEstat (

        val minim: Int = 0,
        val maxim: Int = 999,
        val valorTriat: Int = 500
    )
}