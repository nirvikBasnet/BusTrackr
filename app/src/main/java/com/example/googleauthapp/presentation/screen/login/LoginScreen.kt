package com.example.googleauthapp.presentation.screen.login

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.googleauthapp.domain.model.MessageBarState


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController){
    Scaffold (
        topBar = {
        LoginTopBar()
    },
        content = {
            LoginContent(
                signedInState = false,
               messageBarState =  MessageBarState(),
               onButtonClicked =  {}
            )
        }
    )
}