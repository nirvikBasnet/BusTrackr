package com.example.googleauthapp.presentation.screen.login

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel = hiltViewModel()){

    val signedInState by loginViewModel.signedInState
    val messageBarState by loginViewModel.messageBarState

    Scaffold (
        topBar = {
        LoginTopBar()
    },
        content = {
            LoginContent(
                signedInState = signedInState,
               messageBarState =  messageBarState,
               onButtonClicked =  {
                   loginViewModel.saveSignedInState(true)
               }
            )
        }
    )
}