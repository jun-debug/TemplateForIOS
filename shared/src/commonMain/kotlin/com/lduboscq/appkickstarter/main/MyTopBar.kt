package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
public fun MyTopBar(title: String, backEnabled : Boolean = true, navigateBack: ()-> Unit = {}) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.Blue,
        contentColor = Color.White
    ) {
        if (backEnabled) {
            IconButton(
                onClick = navigateBack,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "go back")
            }
        }
        /********************************************
        binding the text with var title
         *******************************************/

        Text(
            text = "$title",
            modifier = Modifier.fillMaxWidth().weight(1f),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}