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
import com.example.client.domain.model.User
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.Serializable


private val readOnlyProperty = preferencesDataStore(name= Constants.USER_INFORM)

val Context.dataStore: DataStore<Preferences> by readOnlyProperty

private object PreferenceKeys{
    val TOKEN = stringPreferencesKey(Constants.TOKEN)
    val USER = stringPreferencesKey(Constants.USER)
}

class LocalUserManagerImp(private val context: Context): LocalUserManager {
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
            Log.d("LocalUserManager", "Can not save Token")
        }
    }

    override fun readToken(): Flow<String> {
        return context.dataStore.data
            .catch { exception ->
                emit(emptyPreferences())
            }
            .map { preferences ->
                preferences[PreferenceKeys.TOKEN] ?: ""
            }
    }

    override suspend fun saveUser(user: User) {
        try {
            val userJson = Json.encodeToString(user)
            context.dataStore.edit { preferences ->
                preferences[PreferenceKeys.USER] = userJson
            }
        } catch (e: Exception) {
            Log.e("LocalUserManager", "Cannot save user", e)
        }
    }

    override fun readUser(): Flow<User?> {
        return context.dataStore.data
            .catch { exception ->
                Log.e("LocalUserManager", "Error reading user", exception)
                emit(emptyPreferences())
            }
            .map { preferences ->
                val userJson = preferences[PreferenceKeys.USER]
                try {
                    userJson?.let { Json.decodeFromString<User>(it) }
                } catch (e: Exception) {
                    Log.e("LocalUserManager", "Error parsing user JSON", e)
                    null
                }
            }
    }
}
