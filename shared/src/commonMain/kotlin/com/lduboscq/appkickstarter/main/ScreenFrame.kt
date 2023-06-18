package com.lduboscq.appkickstarter.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun ScreenFrame(title: String = "", backEnable : Boolean = true, navigateBack: () -> Unit = {}, content: () -> Unit = {}){

    Scaffold(
        topBar = {
            MyTopBar("Main Form", false)
        },
        bottomBar = {
            MyBottomBar()
        }
    )
    {
        content
    }

}