package cat.institutmontivi.decissorviewmodel.dades

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

// NOTE : los datos se guardan en la parte privada de la aplicación, para ello se necesito el Context
class PreferenciesDataStore(private val context: Context) {

    companion object {

        private val Context.datastore: DataStore<Preferences>
            by preferencesDataStore(("preferencies"))
        private val TEMPS_CARA_O_CREU = longPreferencesKey("tempsCaraOCreu")
        private val MINIM_TRIA_NUMERO = intPreferencesKey("minimTriaNumero")
        private val MAXIM_TRIA_NUMERO = intPreferencesKey("maximTriaNumero")
        private val PREGUNTA_PER_DEFECTE = stringPreferencesKey("preguntaPerDefecte")
    }
}