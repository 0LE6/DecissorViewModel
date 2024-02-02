package cat.institutmontivi.decissorviewmodel.dades

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

// NOTE : los datos se guardan en la parte privada de la aplicación, para ello se necesito el Context
class PreferenciesDataStore(private val context: Context) {

    companion object {

        private val Context.datastore: DataStore<Preferences> by preferencesDataStore(("preferencies"))
    }
}