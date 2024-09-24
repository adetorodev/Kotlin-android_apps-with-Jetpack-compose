package com.adetoro.composeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.adetoro.composeapp.R

@Composable
fun ConstraintLayoutScreens() {
    ConstraintLayout(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val (gradientBackground,
            profileImg, notificationImg,
            welcomeText, questionText, joinBtn,
            courseImg, card,androidImg, javaImg, pythonImg,
            ourCourses
            ) = createRefs()

        val horizontalGuideline1 = createGuidelineFromTop(0.45f)

        BackgroundGradient(modifier = Modifier.constrainAs(gradientBackground){
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            bottom.linkTo(horizontalGuideline1)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

        // header
        val topGuideline = createGuidelineFromTop(24.dp)

        val startGuideline = createGuidelineFromStart(16.dp)
        val endGuideline = createGuidelineFromEnd(16.dp)
//        val bottomGuideline = createGuidelineFromBottom(16.dp)

        createHorizontalChain(
            profileImg, notificationImg,
            chainStyle = ChainStyle.SpreadInside
        )

        ProfileImage(modifier = Modifier.constrainAs(profileImg){
            top.linkTo(topGuideline)
        })

        NotificationImg(modifier = Modifier.constrainAs(notificationImg){
            top.linkTo(profileImg.top)
            bottom.linkTo(profileImg.bottom)
        })

        // Middle Part

        welcomeText(modifier = Modifier
            .constrainAs(welcomeText)
            {
                top.linkTo(profileImg.bottom, margin = 32.dp)
                start.linkTo(startGuideline)
        })

        QuestionText(modifier = Modifier.constrainAs(questionText){
            top.linkTo(welcomeText.bottom, margin = 8.dp)
            start.linkTo(welcomeText.start)
        })

        JoinNowButton(modifier = Modifier.constrainAs(joinBtn){
            top.linkTo(questionText.bottom, margin = 32.dp)
            start.linkTo(questionText.start)
            end.linkTo(questionText.end)
        })

        CourseImage(modifier = Modifier.constrainAs(courseImg){
            bottom.linkTo(horizontalGuideline1)
            end.linkTo(endGuideline)
            start.linkTo(joinBtn.end, margin = 32.dp)
            top.linkTo(joinBtn.top,margin = 32.dp)

            width = Dimension.value(240.dp)
            height = Dimension.fillToConstraints

        })

        // Card
        MyCard(modifier = Modifier.constrainAs(card){
            top.linkTo(horizontalGuideline1, margin = -16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

        // Our Course

        TextOurCourses(modifier = Modifier.constrainAs(ourCourses){
            top.linkTo(card.top, margin = 24.dp)
            start.linkTo(card.start, margin = 24.dp)
        })

        // Course Images

        AndroidImg(modifier = Modifier.constrainAs(androidImg){
            top.linkTo(ourCourses.bottom, margin = 16.dp)
        })

        PythonImg(modifier = Modifier.constrainAs(pythonImg){
            top.linkTo(ourCourses.bottom, margin = 16.dp)
        })

        JavaImg(modifier = Modifier.constrainAs(javaImg){
            top.linkTo(ourCourses.bottom, margin = 16.dp)
        })

        createHorizontalChain(
            androidImg, pythonImg,javaImg,
            chainStyle = ChainStyle.Spread
        )


    }
}

@Composable
fun BackgroundGradient(modifier: Modifier){
    Image(

        painterResource(id = R.drawable.gradient_background),
        contentDescription = "background Image" ,
        contentScale = ContentScale.FillBounds,
        modifier = modifier.alpha(0.8f))
}