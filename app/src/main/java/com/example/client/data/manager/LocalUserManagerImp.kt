package com.example.client.data.manager

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.client.domain.manager.LocalUserManager
import com.example.client.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.catch
import androidx.datastore.preferences.core.emptyPreferences

private val readOnlyProperty = preferencesDataStore(name= Constants.USER_INFORM)

val Context.dataStore: DataStore<Preferences> by readOnlyProperty

private object PreferenceKeys{
    val TOKEN = stringPreferencesKey(Constants.TOKEN)
}

class LocalUserManagerImp(private val context: Context): LocalUserManager {
//    override fun readToken(): Flow<String> {
//        return context.dataStore.data.map { preferences ->
//            preferences[PreferenceKeys.TOKEN] ?: ""
//        }
//    }
    override suspend fun saveToken(token: String?) {
        try {
            context.dataStore.edit { information ->
                if (token != null) {
                    information[PreferenceKeys.TOKEN] = token
                } else {
                    information.remove(PreferenceKeys.TOKEN)
                }
            }
        } catch (e: Exception) {
            Log.d("LocalUserManagerImp", "Exception happend")
        }
    }

    override fun readToken(): Flow<String> {
        return context.dataStore.data
            .catch { exception ->
                // Log error hoặc emit empty string
                emit(emptyPreferences())
            }
            .map { preferences ->
                preferences[PreferenceKeys.TOKEN] ?: ""
            }
    }
}
