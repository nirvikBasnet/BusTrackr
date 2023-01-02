package com.example.googleauthapp.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.googleauthapp.domain.model.repository.DataStoreOperations
import com.example.googleauthapp.util.Constants.PREFERENCES_SIGNED_IN_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DataStoreOperationsImpl @Inject constructor(
    private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences>
):DataStoreOperations{

    private object PreferencesKey{
        val signedInKey = booleanPreferencesKey(name = PREFERENCES_SIGNED_IN_KEY)
    }

    override suspend fun saveSignedInState(signedIn: Boolean) {
       dataStore.edit { preferences ->
           preferences[PreferencesKey.signedInKey] = signedIn
       }
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception->
                if(exception is IOException ){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }
            .map {
                preference ->
                val signedInState = preference[PreferencesKey.signedInKey]?: false
                signedInState
            }
    }

}