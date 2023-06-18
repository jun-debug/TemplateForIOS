package com.lduboscq.appkickstarter.main
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow


internal class MyMainScreen : Screen {

    @Composable
    override fun Content() {
        var isLogin by remember { mutableStateOf(false) }
        var username = "";
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                ) {

                    Text(
                        text = "Welcome",
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        textAlign = TextAlign.Center
                    )
                    /********************************************
                    when click this button, it will change the title back and forth
                     *******************************************/
                    IconButton(
                        onClick = {
                            navigator.push(InfoScreen())
                        },
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    ) {
                        Icon(imageVector = Icons.Default.Phone, contentDescription = "Contact us")
                    }

                    IconButton(
                        onClick = {
                                  navigator.push(ContactScreen())
                        },
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    ) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = "information")
                    }
                }
            },
            bottomBar = {
                MyBottomBar{
                    IconButton(
                        onClick = { isLogin = false}
                    )
                    {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "Logout")
                    }
                }
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