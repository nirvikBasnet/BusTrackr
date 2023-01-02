package com.example.googleauthapp.domain.model.repository

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun signedInState(signedIn : Boolean)
    fun readSignedInState(): Flow<Boolean>
}

