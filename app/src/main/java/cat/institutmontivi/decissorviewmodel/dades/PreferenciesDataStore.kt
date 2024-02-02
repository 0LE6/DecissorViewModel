package cat.institutmontivi.decissorviewmodel.dades

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// NOTE : los datos se guardan en la parte privada de la aplicación, para ello se necesito el Context
class PreferenciesDataStore(private val context: Context) {

    companion object {
        private val Context.datastore: DataStore<Preferences>
            by preferencesDataStore(("preferencies")) // NOTE : preferencies sera donde se guardará

        private val TEMPS_CARA_O_CREU = longPreferencesKey("tempsCaraOCreu")
        private val MINIM_TRIA_NUMERO = intPreferencesKey("minimTriaNumero")
        private val MAXIM_TRIA_NUMERO = intPreferencesKey("maximTriaNumero")
        private val PREGUNTA_PER_DEFECTE = stringPreferencesKey("preguntaPerDefecte")
    }

    val getTempsCaraOCreo: Flow<Long> = context.datastore.data.map {
        preferencies -> preferencies[TEMPS_CARA_O_CREU] ?: 0
    }

    suspend fun saveTempsCaraOCreu(valor: Long) {
        context.datastore.edit {
                preferencies -> preferencies[TEMPS_CARA_O_CREU] = valor
        }
    }
}