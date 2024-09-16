package com.adetoro.composeapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
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
            AppPreview()
        }
    }
}

@Composable
fun textFiled(){
    var text by remember {
        mutableStateOf(TextFieldValue())
    }
    TextField(value = text, onValueChange = {
        newValue -> text = newValue
    } )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    textFiled()
}
//// fill Button - summit or save
//@Composable
//fun fillButton(onClick: () -> Unit){
//    Button(onClick = {
//onClick()
//    }) {
//        Text(text = "Click Me")
//    }
//}
//
//// 2 Filled Tonal - add to cart, sign in
//
//@Composable
//fun filledTonalButton(onClick: () -> Unit){
//    FilledTonalButton(onClick = { onClick () }) {
//        Text(text = "Fill Button")
//    }
//}
//
//// 3 Elevated Button
//
//@Composable
//fun elevatedButton(onClick: () -> Unit){
//    ElevatedButton(onClick = { onClick () }, elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp))
//
//    {
//        Text(text = "elevated Button")
//    }
//}
//
//// 4. outline button
//@Composable
//fun outlineButton(onClick: () -> Unit){
//    OutlinedButton(onClick = { onClick () }) {
//        Text(text = "Fill Button")
//    }
//}
//
//// Text Button
//@Composable
//fun textButton(onClick: () -> Unit){
//    TextButton(onClick = { onClick () }) {
//        Text(text = "Fill Button")
//    }
//}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Column(modifier = Modifier
//        .padding(all = 12.dp, )
//        .border(1.dp, androidx.compose.ui.graphics.Color.Red)
//        .padding(all = 16.dp)
//        .border(2.dp, androidx.compose.ui.graphics.Color.Blue)
//
//    ) {
//
//        Text(
//            text = "Hello Coding Master",
//            color = androidx.compose.ui.graphics.Color.Red,
//            fontFamily = FontFamily.Serif,
//            fontSize = 38.sp,
//            textDecoration = TextDecoration.combine(
//                listOf(
//                    TextDecoration.LineThrough,
//                    TextDecoration.Underline
//                )
//            ),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.padding(start = 10.dp)
//        )
//        Text(
//            text = "Download Now"
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//        Greeting("Android")
//}

