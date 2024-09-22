package com.adetoro.composeapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen(
    navigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="Setting Screen", fontSize = 50.sp)
        Button(onClick = navigateToHome ) {
            Text(text="Go to Home")
        }
    }
}