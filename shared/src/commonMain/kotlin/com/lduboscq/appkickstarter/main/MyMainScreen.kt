package com.lduboscq.appkickstarter.main
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen


internal class MyMainScreen : Screen {

    @Composable
    override fun Content() {

        var isLogin by remember { mutableStateOf(false) }
        var username = "";
        Scaffold(
            topBar = {
                MyTopBar("Main Form")
            },
            bottomBar = {
                MyBottomBar()
            }
        )
        {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /**************************************************************
                when it is not login, it is going to show the login form
                 ************************************************************/

                AnimatedVisibility(!isLogin) {
                    LoginForm(onLoginClicked = {
                        username = it
                        isLogin = true
                    })
                }

                /*******************************************************
                it will show welcome form after login successfully
                 *****************************************************/


                AnimatedVisibility(isLogin) {
                    WelcomeForm(username)
                }
            }
        }
    }

}