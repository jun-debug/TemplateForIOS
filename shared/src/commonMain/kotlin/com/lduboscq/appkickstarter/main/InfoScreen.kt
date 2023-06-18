package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lduboscq.appkickstarter.ui.Image

internal class InfoScreen : Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold (
            topBar = {
                MyTopBar( title = "About my app"){
                    navigator.pop()
                }
            },
            bottomBar = {
                MyBottomBar()
            }
        ) {
            Image(
               url =  "https://appinventiv.com/wp-content/uploads/sites/1/2020/02/mobile-app-architecture.png" )
            Spacer(Modifier.height(30.dp))
            Text("It is a multi platform app.", textAlign = TextAlign.Center)
        }
    }

}