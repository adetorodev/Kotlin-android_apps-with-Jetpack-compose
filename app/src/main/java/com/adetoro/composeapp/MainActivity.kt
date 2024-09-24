@file:OptIn(ExperimentalMaterial3Api::class)

package com.adetoro.composeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adetoro.composeapp.screens.ConstraintLayoutScreens

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstraintLayoutScreens()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ConstraintLayoutScreens()
}
