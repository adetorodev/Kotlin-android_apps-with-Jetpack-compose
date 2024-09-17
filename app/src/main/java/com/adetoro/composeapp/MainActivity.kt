@file:OptIn(ExperimentalMaterial3Api::class)

package com.adetoro.composeapp

import android.graphics.Color
import android.graphics.Color.*
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.adetoro.composeapp.ui.theme.ComposeAppTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity(), NetworkStateListener by NetworkStateHandler() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyScaffold()
        }
    }


}

@Preview(showBackground = true)
@Composable
fun MyScaffold() {
    Scaffold(
        topBar = { MyTopappBar() },
        bottomBar = {MyBottomAppBar()},
        floatingActionButton = { MyFab() }
    ) {
        paddingValues -> Log.d("Tagg", "The padding vale $paddingValues")
        MyColumn()
    }
}

@Composable
fun MyFab() {
    val context = LocalContext.current
    FloatingActionButton(onClick = { Toast.makeText(
        context,
        "Add to value",
        Toast.LENGTH_SHORT
    ).show()
    },
        containerColor = Red,
        contentColor = White
        ) {
        Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "Add")
    }
}

@Composable
fun MyTopappBar() {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "TopAppBar Title") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Green,
            titleContentColor = Blue
        ),
        navigationIcon = {
            IconButton(onClick = {

                Toast.makeText(
                    context,
                    "You click on menu",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                androidx.compose.material3.Icon(
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
                androidx.compose.material3.Icon(
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = "Menu"
                )
            }
        }
    )
}

@Composable
fun MyBottomAppBar() {
    val context = LocalContext.current
    BottomAppBar (
        containerColor = DarkGray,
        contentColor = Yellow,

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
                androidx.compose.material3.Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "Home"
                )
            }
            IconButton(onClick = {  Toast.makeText(
                context,
                "you Click the Item bookmarked successsn",
                Toast.LENGTH_SHORT
            ).show() }) {
                androidx.compose.material3.Icon(
                    painter = painterResource(id = R.drawable.baseline_collections_bookmark_24),
                    contentDescription = "Bookmark"
                )
            }
            IconButton(onClick = {  Toast.makeText(
                context,
                "you Click the You can opdate profile",
                Toast.LENGTH_SHORT
            ).show() }) {
                androidx.compose.material3.Icon(
                    painter = painterResource(id = R.drawable.baseline_people_alt_24),
                    contentDescription = "Bookmark"
                )
            }
        }
        }


}

//@Preview(showBackground = true)
//@Composable
//fun MySurface() {
//    Surface (
//        modifier = Modifier.size(100.dp),
//        color = androidx.compose.ui.graphics.Color.Red,
//        contentColor = colorResource(id = R.color.purple_200),
//        shadowElevation = 1.dp,
////        border = BorderStroke(1.dp, Color.GREEN)
//    ) {
//        Text(text="Welcome Back")
//        Text(text="Download our health app today")
//        Text(text="Download from Playstore")
//
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun MyBox() {
//    Box(
//
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Text(text="Welcome Back",
//        modifier = Modifier.align(Alignment.TopStart))
//        Text(text="Download our health app today",
//            modifier = Modifier.align(Alignment.Center) )
//        Text(text="Download from Playstore",
//            modifier = Modifier.align(Alignment.BottomEnd))
//    }
//}

//@Preview(showBackground = true)
@Composable
fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
    ) {
        Text(text="Welcome Back")
        Text(text="Download our health app today")
        Text(text="Download from Playstore")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MyRow() {
//    Row(
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Text(text="Welcome Back")
//        Text(text="Download our health app today")
//        Text(text="Download from Playstore")
//    }
//}



