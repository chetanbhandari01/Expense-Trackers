import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.chetanbhandari.expensemanager.core.datastore.CurrencyDataStore
import com.chetanbhandari.expensemanager.core.datastore.DateRangeDataStore
import com.chetanbhandari.expensemanager.core.datastore.DeviceLocalDataStore
import com.chetanbhandari.expensemanager.core.datastore.FeedbackDataStore
import com.chetanbhandari.expensemanager.core.datastore.LocaleDataStore
import com.chetanbhandari.expensemanager.core.datastore.ReminderTimeDataStore
import com.chetanbhandari.expensemanager.core.datastore.SettingsDataStore
import com.chetanbhandari.expensemanager.core.datastore.ThemeDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DATA_STORE_NAME = "expense_manager_app_data_store"

private val Context.dataStore by preferencesDataStore(DATA_STORE_NAME)

// Not backed up (see DeviceLocalDataStore).
private val Context.deviceLocalDataStore by preferencesDataStore(DeviceLocalDataStore.FILE_NAME)

val DatastoreModule = module {
    single { androidContext().dataStore }
    single { ThemeDataStore(get()) }
    single { LocaleDataStore(get()) }
    single { CurrencyDataStore(get()) }
    single { ReminderTimeDataStore(get()) }
    single { SettingsDataStore(get()) }
    single { DateRangeDataStore(get()) }
    single { FeedbackDataStore(get()) }
    // Built directly (not via get()) so it can never pick up the backed-up DataStore by type.
    single { DeviceLocalDataStore(androidContext().deviceLocalDataStore) }
}
