package com.adetoro.composeapp.widgets

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.adetoro.composeapp.R

@Composable
fun MyBottomAppBar() {
    val context = LocalContext.current
    BottomAppBar (
        containerColor = Color.DarkGray,
        contentColor = Color.Yellow,

        ) {
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(onClick = {  Toast.makeText(
                context,
                "you Click the home button",
                Toast.LENGTH_SHORT
            ).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "Home"
                )
            }
            IconButton(onClick = {  Toast.makeText(
                context,
                "you Click the Item bookmarked successsn",
                Toast.LENGTH_SHORT
            ).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_collections_bookmark_24),
                    contentDescription = "Bookmark"
                )
            }
            IconButton(onClick = {  Toast.makeText(
                context,
                "you Click the You can opdate profile",
                Toast.LENGTH_SHORT
            ).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_people_alt_24),
                    contentDescription = "Bookmark"
                )
            }
        }
    }


}