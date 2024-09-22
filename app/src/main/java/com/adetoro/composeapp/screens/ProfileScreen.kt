package com.adetoro.composeapp.screens

import android.telecom.Call.Details
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
fun ProfileScreen (
    id: Int,
    showDetails: Boolean,
    navigateToSetting: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Screen", fontSize = 50.sp)
        Text(text = "Profile Id: $id", fontSize = 40.sp)
        Text(text = "Profile showDetails: $showDetails", fontSize = 40.sp)
        Button(onClick =  navigateToSetting ) {
            Text(text = "To to Setting")

        }
    }
}