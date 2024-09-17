@file:OptIn(ExperimentalMaterial3Api::class)

package com.adetoro.composeapp
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adetoro.composeapp.widgets.MyBottomAppBar
import com.adetoro.composeapp.widgets.MyFab
import com.adetoro.composeapp.widgets.MyTopappBar

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
        AppContent()
    }
}

//@Preview(showBackground = true)
@Composable
fun AppContent() {
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




