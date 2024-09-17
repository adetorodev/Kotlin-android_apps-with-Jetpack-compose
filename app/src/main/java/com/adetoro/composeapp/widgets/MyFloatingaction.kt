package com.adetoro.composeapp.widgets

import android.widget.Toast
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.adetoro.composeapp.R

@Composable
fun MyFab() {
    val context = LocalContext.current
    FloatingActionButton(onClick = { Toast.makeText(
        context,
        "Add to value",
        Toast.LENGTH_SHORT
    ).show()
    },
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "Add")
    }
}