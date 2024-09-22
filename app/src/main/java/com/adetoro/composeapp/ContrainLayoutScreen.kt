package com.adetoro.composeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ContainLayoutScreen() {

    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

        val (box1, box2, text) = createRefs()
//        guideline
        val guideline = createGuidelineFromStart(0.05f)
        // barrier
        val barrier = createEndBarrier(box1, box2)

        Box(modifier = Modifier.size(70.dp)
            .background(Red)
            .constrainAs(box1) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(guideline)
            }
        )
        Box(modifier = Modifier.size(100.dp)
            .background(Green)
            .constrainAs(box2){
                top.linkTo(box1.bottom, margin= 20.dp)
                start.linkTo(guideline)
            }
        )
        Text(text= "hello everyone there", modifier = Modifier.constrainAs(text){
            top.linkTo(box2.bottom, margin = 16.dp)
            start.linkTo(barrier, margin = 16.dp)
        })
    }
}