package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MyBottomBar(content: @Composable () -> Unit = {}) {
    BottomAppBar {
        Text(
            "Copyright (c) 2023 Jun Liang",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
        content
    }
}