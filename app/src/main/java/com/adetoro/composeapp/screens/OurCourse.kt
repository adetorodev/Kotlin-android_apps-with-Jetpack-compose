package com.adetoro.composeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adetoro.composeapp.R

@Composable
fun TextOurCourses(modifier: Modifier){
    Text(
        text = "Our Courses",
        modifier = modifier,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Black)

}

@Composable
fun AndroidImg(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.medicines_icon),
        contentDescription = "Android Image",
        modifier = modifier.size(90.dp))
}

@Composable
fun PythonImg(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.consultation_icon),
        contentDescription = "Android Image",
        modifier = modifier.size(90.dp))
}

@Composable
fun JavaImg(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.ambulance_icon),
        contentDescription = "Android Image",
        modifier = modifier.size(90.dp))
}