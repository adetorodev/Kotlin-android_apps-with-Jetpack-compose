package com.adetoro.composeapp

import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LinearProgress(progress: Float) {
    LinearProgressIndicator(progress = progress )
}

@Composable
fun IncreaseProgressButton(onclickButton: () -> Unit) {
    Button(onClick = onclickButton) {
        Text(text = "Click to increase")
    }
}

@Composable
fun IncreaseProgressText(progress: Float) {
    Text(text = "The progress is: $progress")
}

