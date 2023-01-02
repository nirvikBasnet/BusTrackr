package com.example.googleauthapp.domain.model.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun  saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>
}