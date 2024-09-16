package com.adetoro.composeapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adetoro.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting(
                name = "Android",
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .padding(all = 12.dp, )
        .border(1.dp, androidx.compose.ui.graphics.Color.Red)
        .padding(all = 16.dp)
        .border(2.dp, androidx.compose.ui.graphics.Color.Blue)

    ) {

        Text(
            text = "Hello Coding Master",
            color = androidx.compose.ui.graphics.Color.Red,
            fontFamily = FontFamily.Serif,
            fontSize = 38.sp,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough,
                    TextDecoration.Underline
                )
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = "Download Now"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        Greeting("Android")
}

