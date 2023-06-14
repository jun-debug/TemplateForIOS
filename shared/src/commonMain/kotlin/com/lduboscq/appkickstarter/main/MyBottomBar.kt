package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MyBottomBar() {
    BottomAppBar {
        Text(
            "Copyright (c) 2023 Jun Liang",
            modifier = Modifier.fillMaxWidth().weight(1f),
            textAlign = TextAlign.Center
        )
    }
}