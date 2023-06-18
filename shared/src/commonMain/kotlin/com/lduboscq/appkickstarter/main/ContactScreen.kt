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

internal class ContactScreen : Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold (
            topBar = {
                MyTopBar( title = "Contact us"){
                    navigator.pop()
                }
            },
            bottomBar = {
                MyBottomBar()
            }
        ) {
            Image(url = "https://www.thousandperhour.com/image/data/contact_us_.png")
            Spacer(Modifier.height(40.dp))
            Text("Call us: 1-888-888-888", textAlign = TextAlign.Center)
            Spacer(Modifier.height(20.dp))
            Text("Email: it_support@abc.com", textAlign = TextAlign.Center)
        }
    }

}