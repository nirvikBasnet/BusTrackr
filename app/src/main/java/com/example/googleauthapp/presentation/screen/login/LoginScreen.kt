package com.example.googleauthapp.presentation.screen.login

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.googleauthapp.presentation.screen.common.StartActivityForResult
import com.example.googleauthapp.presentation.screen.common.signIn


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

    val activity = LocalContext.current as Activity

    StartActivityForResult(
        signedInState,
        onResultReceived = {
            tokenId ->

        },
        onDialogDismissed = {
            loginViewModel.saveSignedInState(false)
        }
    ){ activityLauncher ->
        if(signedInState){
            signIn(
                activity =activity,
                launchActivityResult = {
                    activityLauncher.launch(it)
                },
                accountNotFound = {
                    loginViewModel.saveSignedInState(false)
                }
            )
        }
    }
}