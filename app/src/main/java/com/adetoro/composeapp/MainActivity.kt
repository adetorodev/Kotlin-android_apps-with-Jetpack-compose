package com.adetoro.composeapp

import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.adetoro.composeapp.ui.theme.ComposeAppTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppPreview()
        }
    }
}


//fun myTextField(icon: Icon, label: String, placeholder: String, textV: Text, modifier:Modifier = Modifier.padding(start = 5.dp).align(alignment = Alignment.CenterHorizontally)){
//    TextField(value = textV,
//        modifier = modifier,
//        leadingIcon = icon,
//        onValueChange = {newText -> text = newText},
//        label = label,
//        placeholder = placeholder
//    )
//}


@Composable
fun registerForm(){
    var text by remember {
        mutableStateOf(TextFieldValue(" "))
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text="Register",
            textAlign = TextAlign.Start,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(all = 4.dp),
        )

           TextField(value = text,
               leadingIcon = {Icon(imageVector = Icons.Default.Person, contentDescription="Person Icon")},
               onValueChange = {newText -> text = newText},
               label = {Text(text="Your Name", fontSize = 18.sp)},
               placeholder = {Text(text="Enter your name")}
           )
           TextField(value = text,
               leadingIcon = {Icon(imageVector = Icons.Default.Person, contentDescription="Person Icon")},
               onValueChange = {newText -> text = newText},
               label = {Text(text="Username", fontSize = 18.sp)},
               placeholder = {Text(text="Enter your username")},
           )
           TextField(value = text,
               leadingIcon = {Icon(imageVector = Icons.Default.Email, contentDescription="Email Icon")},
               onValueChange = {newText -> text = newText},
               label = {Text(text="Email", fontSize = 18.sp)},
               placeholder = {Text(text="Enter your email")}
           )
           TextField(value = text,
               leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription="Lock Icon")},
               onValueChange = {newText -> text = newText},
               label = {Text(text="Password", fontSize = 18.sp)},
               placeholder = {Text(text="Enter your password")}
           )
           TextField(value = text,
               leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription="Lock Icon", modifier = Modifier.padding(all = 3.dp))},
               onValueChange = {newText -> text = newText},
               label = {Text(text="Corfirm Password", fontSize = 18.sp)},
               placeholder = {Text(text="Enter your password")}
           )
        FilledTonalButton(onClick = { /*TODO*/ } ,) {
            Text(text = "Sign Up with Apple")
        }
        Text(text="Continue with: ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(all = 4.dp),
        )

        Row(modifier = Modifier.padding(bottom = 14.dp)) {
            FilledTonalButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(all=4.dp)) {
                Text(text = "Sign Up Google")
            }
            FilledTonalButton(onClick = { /*TODO*/ }) {
                Text(text = "Sign Up with Apple")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    registerForm()
}

//@Composable
//fun textFiled(){
//    var text by remember {
//        mutableStateOf(TextFieldValue())
//    }
//    TextField(value = text, onValueChange = {
//        newValue -> text = newValue
//    } )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun AppPreview() {
//    textFiled()
//}
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

