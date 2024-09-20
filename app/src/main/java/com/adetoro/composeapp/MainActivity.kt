@file:OptIn(ExperimentalMaterial3Api::class)

package com.adetoro.composeapp

import android.content.ClipData
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            lazyColumnWithStickyHeader()

            // create the NavController
            val navController = rememberNavController()

            // create the navHost
            NavHost(
                navController = navController,
                startDestination = "first"
            ) {
                composable("first") {
                    FirstScreen(navController)
                }
                composable("second_screen/{userName}?age={age}",
                    arguments = listOf(
                        navArgument("userName") {
                            type = NavType.StringType
                        },
                        navArgument("age"){
                            type = NavType.StringType
                            defaultValue = "30"
                            nullable = true
                        }

                    )
                ) { backStackEntry ->
                    SecondScreen(
                        navController,
                        backStackEntry.arguments?.getString("userName").toString(),
                        backStackEntry.arguments?.getString("age").toString()
                    )
                }
            }
        }
    }
//@Preview(showBackground = true)
//@Composable
//fun Apppreview() {
//    FirstScreen()
//}

    @Composable
    fun FirstScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .padding(50.dp)
        ) {
            Text(text = "This is the first screen")

            var enteredText by remember {
                mutableStateOf("")
            }

            TextField(
                value = enteredText,
                onValueChange = { enteredText = it },
                label = { Text(text = "Enter your Name") }
            )

            var enteredText2 by remember {
                mutableStateOf("")
            }

            TextField(
                value = enteredText2,
                onValueChange = { enteredText2 = it },
                label = { Text(text = "Enter your Ocupation") }
            )

            Button(onClick = {

                navController.navigate("second_screen/$enteredText/?age=$enteredText2")
            }) {
                Text(text = "Go to 2nd Screen")
            }
        }
    }

    @Composable
    fun SecondScreen(navController: NavController, userName: String, age: String) {
        Column(
            modifier = Modifier
                .padding(50.dp)
        ) {
            Text(text = "Welcome ${userName} you are ${age}")
            Button(onClick = {
//                navController.navigate("first_screen")
                navController.navigateUp()  // navigate back to previous screen
            }) {
                Text(text = "Go to 1st Screen")
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun lazyColumnWithStickyHeader() {
        val groupedItems = mapOf(
            "Fruits " to listOf(
                Item("Apple", "very health", R.drawable.apple),
                Item("Banana", "A long yellow fruit", R.drawable.bananas),
                Item("Cherry", "A small red fruit", R.drawable.cherry),
                Item("Mango", "A long green fruit", R.drawable.mango),
                Item("Watermelon", "A long green fruit", R.drawable.watermelon),
                Item("Grapes", "Tasty fruit", R.drawable.grapes),

                ),
            "Vegetable" to listOf(
                Item("Carrot", "A long green fruit", R.drawable.carrot),
                Item("Lettuce", "A long green fruit", R.drawable.lettuce),
                Item("Broccoli", "A long green fruit", R.drawable.brocoli),
                Item("Onion", "A long green fruit", R.drawable.onion),
                Item("Potato", "A long green fruit", R.drawable.potato),
                Item("Tomato", "A long green fruit", R.drawable.tomato),
                Item("Peas", "A long green fruit", R.drawable.pea),


                )
        )
        val myFruit = groupedItems["Fruits"]

        LazyColumn {
            groupedItems.forEach { (header, items) ->
                stickyHeader {
                    MyCustomHeader(title = header)
                }
                items(items) { item ->
                    MyCustomItem(item)
                }
            }
        }
    }

    @Composable
    fun MyCustomHeader(title: String) {
        Text(
            text = title,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Green)
                .padding(8.dp)
        )
    }

    @Composable
    fun MyCustomItem(item: Item) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            )
            {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.title, fontSize = 22.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.desc, fontSize = 18.sp)
            }
        }
    }
}

