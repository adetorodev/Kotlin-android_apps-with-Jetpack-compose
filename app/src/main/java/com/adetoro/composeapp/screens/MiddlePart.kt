package com.adetoro.composeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adetoro.composeapp.R

@Composable
fun welcomeText(modifier: Modifier){
    Text(text = "Welcome back!",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Red,
        modifier = modifier
        )
}

@Composable
fun QuestionText(modifier: Modifier){

    Text(text="What do you want to learn today?",
        color = Gray,
        modifier = modifier
        )
}

@Composable
fun JoinNowButton(modifier: Modifier){
    Button(onClick = { /*TODO*/ }, modifier = modifier) {
        Text(text = "Join Now")

    }
}

@Composable
fun CourseImage(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.lettuce),
        contentDescription = "Course", modifier = modifier)


}