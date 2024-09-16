package com.adetoro.composeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


//class StateManActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Counter()
//        }
//    }
//}
@Composable
fun Counter() {
    var count = remember {
        mutableStateOf(0)
    }
    Column {
        Text("The Counter ${count.value}")
        Button(onClick = {
            count.value++
            Log.v("TAGY", "Count value: $count")
        }) {
            Text(text = "Count")
        }
    }
}

