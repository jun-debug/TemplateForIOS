package com.lduboscq.appkickstarter

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.lduboscq.appkickstarter.main.MyMainScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
public fun MainApp() {
    Navigator(MyMainScreen()) { navigator ->
        SlideTransition(navigator)
    }
}
