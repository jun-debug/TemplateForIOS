package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
public fun MyTopBar(title: String) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.Blue,
        contentColor = Color.White
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        ){
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "information")
        }
        /********************************************
        binding the text with var title
         *******************************************/

        Text(
            text = "$title",
            modifier = Modifier.fillMaxWidth().weight(1f),
            textAlign = TextAlign.Center
        )

        /********************************************
        when click this button, it will change the title back and forth
         *******************************************/

        IconButton(
            onClick = {
            },
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = "information")
        }
    }
}