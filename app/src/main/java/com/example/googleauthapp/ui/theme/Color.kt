package com.example.googleauthapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Gray500 = Color(0xFF546E7A)
val LoadingBlue = Color(0xFF1A73E8)
val ErrorRed = Color(0xFFFF6C60)
val InfoGreen = Color(0xFF00C096)

val Colors.topAppBarContentColor : Color
get() = if(isLight) Color.White else Color.LightGray

val Colors.topAppBarBackgroundColor : Color
    get() = if(isLight) Gray500 else Color.LightGray