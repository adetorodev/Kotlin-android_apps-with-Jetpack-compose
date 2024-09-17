package com.adetoro.composeapp

import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.Toast
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
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
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.adetoro.composeapp.ui.theme.ComposeAppTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity(), NetworkStateListener by NetworkStateHandler() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var progress by remember {
                mutableStateOf(0.0f)
            }
            Column(verticalArrangement = Arrangement.Center) {
                LinearProgress(progress = progress)
                IncreaseProgressButton{
                    progress += 0.1f
                    if(progress > 1.0f){
                        progress = 0.0f
                    }
            }
                IncreaseProgressText(progress)
            }
        }
    }
}
//
//@Composable
//fun progressIndicatorChallenge(progress: Float, onclickButton: () -> Unit, text: String){
//    Column {
//        ElevatedButton(onClick = onclickButton) {
//            Text(text = "Click to increase")
//        }
//        LinearProgressIndicator(progress = progress )
//    }
//    Text(text= text)
//}

//@Composable
//fun RadioButtonRow(text: String, isSelected: Boolean, onSelect: () -> Unit) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        RadioButton(selected = isSelected, onClick = onSelect, modifier = Modifier.padding(vertical = 4.dp))
//        Text(text=text)
//    }
//}

//@Composable
//fun RadioButtonExample(){
//    var selectedOption by remember {
//        mutableStateOf("option 1")
//    }
//
//    var checked by remember {
//        mutableStateOf(false)
//    }
//
//    Column {
//        RadioButtonRow(
//            "option 1",
//            selectedOption == "option 1",
//            {selectedOption = "option 1"}
//        )
//        RadioButtonRow(
//            "option 2",
//            selectedOption == "option 2",
//            {selectedOption = "option 2"}
//        )
//        RadioButtonRow(
//            "option 3",
//            selectedOption == "option 3",
//            {selectedOption = "option 3"}
//        )
//        CircularProgressIndicator(progress = 0.5f )
//        LinearProgressIndicator(progress = 0.7f)
//    }



//    Column {
//        RadioButton(selected = selectedOption == "option 1", onClick = { selectedOption = "option 1" })
//        RadioButton(selected = selectedOption == "option 2", onClick = { selectedOption = "option 2" })
//        RadioButton(selected = selectedOption == "option 3", onClick = { selectedOption = "option 3" })
//    }


//    Row {
//        Switch(checked = checked, onCheckedChange = {checked = it} )
//    }

//    Checkbox(checked = checked, onCheckedChange = {
//            isChecked -> checked = isChecked
//        Toast.makeText(this, "is check $checked", Toast.LENGTH_SHORT ).show()
//    } )

//}

//@Preview
//@Composable
//fun AppPreview() {
//    progressIndicatorChallenge()
//}

//@Composable
//fun SwitchExample(){
//    var checked by remember {
//        mutableStateOf(false)
//    }
//
//    Switch(checked = checked, onCheckedChange = {checked = it} )
//
////    Checkbox(checked = checked, onCheckedChange = {
////            isChecked -> checked = isChecked
////        Toast.makeText(this, "is check $checked", Toast.LENGTH_SHORT ).show()
////    } )
//
//}

//@Composable
//fun CheckboxExample(){
//    var checked by remember {
//        mutableStateOf(false)
//    }
//
//    Checkbox(checked = checked, onCheckedChange = {
//        isChecked -> checked = isChecked
//        Toast.makeText(this, "is check $checked", Toast.LENGTH_SHORT ).show()
//    } )
//
//}

//@Composable
//fun StatefulTextField() {
//    var name by remember {
//        mutableStateOf("")
//    }
//
//    var occupation by remember {
//        mutableStateOf("")
//    }
//
//    Column {
//        OutlinedTextField(value = name, onValueChange = {
//            newText -> name = newText
//        }, label = {Text(text="Enter you Name")} )
//        TextField(value = occupation, onValueChange = { newText ->
//            occupation = newText
//        }, label = { Text(text = "Enter Enter your Occupation") })
//        Text(text = "Welcome  $name")
//        Text(text="You are a $occupation")
//    }
//}

//State Hoisting

//fun StatefulTextField() {
//    var text by remember {
//        mutableStateOf("")
//    }
//
//
//    Column {
//
//        TextField(value = text, onValueChange = { newText ->
//            text = newText
//        }, label = { Text(text = "Enter Enter your Occupation") })
//        Text(text = "Welcome  $text")
//    }
//}

//@Composable
//fun statelessTextField(
//    text: String,
//    onTextChanged: (String) -> Unit
//){
//    Column {
//        TextField( value = text, onValueChange = onTextChanged, label ={Text(text= "Enter a text")} )
//        Text(text="You type $text")
//    }
//
//}



//@Preview
//@Composable
//fun AppPreview() {
//    StatefulTextField()
//}
