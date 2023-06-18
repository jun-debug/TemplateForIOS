package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
                MyTopBar( title = "About us"){
                    navigator.pop()
                }
            },
            bottomBar = {
                MyBottomBar()
            }
        ) {
            Column(
                modifier = Modifier.padding(30.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    url = "https://appinventiv.com/wp-content/uploads/sites/1/2020/02/mobile-app-architecture.png",
                    modifier = Modifier.fillMaxSize().weight(1f),
                    contentScale = ContentScale.Fit
                )
                Spacer(Modifier.height(30.dp))
                Text("It is a multi platform app.", textAlign = TextAlign.Center)
                Spacer(Modifier.height(100.dp))
            }
        }
    }

}