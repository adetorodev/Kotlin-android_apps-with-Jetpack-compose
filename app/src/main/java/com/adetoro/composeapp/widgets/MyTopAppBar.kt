package com.adetoro.composeapp.widgets

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.adetoro.composeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopappBar() {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "TopAppBar Title") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Green,
            titleContentColor = Color.Blue
        ),
        navigationIcon = {
            IconButton(onClick = {

                Toast.makeText(
                    context,
                    "You click on menu",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "you Click the Setting",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = "Menu"
                )
            }
        }
    )
}