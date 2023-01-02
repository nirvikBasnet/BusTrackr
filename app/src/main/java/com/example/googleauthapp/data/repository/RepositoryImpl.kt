package com.example.googleauthapp.data.repository

import com.example.googleauthapp.domain.model.repository.DataStoreOperations
import com.example.googleauthapp.domain.model.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataStoreOperations: DataStoreOperations
): Repository {
    override suspend fun signedInState(signedIn: Boolean) {
        dataStoreOperations.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()
    }
}