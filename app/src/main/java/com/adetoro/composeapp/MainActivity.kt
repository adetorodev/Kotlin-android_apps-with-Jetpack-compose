@file:OptIn(ExperimentalMaterial3Api::class)

package com.adetoro.composeapp
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adetoro.composeapp.widgets.MyBottomAppBar
import com.adetoro.composeapp.widgets.MyFab
import com.adetoro.composeapp.widgets.MyTopappBar

class MainActivity : ComponentActivity(), NetworkStateListener by NetworkStateHandler() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mycard()
        }
    }
}

@Composable
fun Mycard() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp).background(Blue),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(Green)
    ) {
        Text(text= "Simple Card", modifier = Modifier.padding(8.dp))
    }
}

//@Preview(showBackground = true)
@Composable
fun MyScaffold() {
    Scaffold(
        topBar = { MyTopappBar() },
        bottomBar = {MyBottomAppBar()},
        floatingActionButton = { MyFab() }
    ) {
        paddingValues -> Log.d("Tagg", "The padding vale $paddingValues")
        myLazyColumn()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun myLazyColumn() {
    val itemList = listOf<String>("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1",
        "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    LazyColumn {
        stickyHeader {
            Text(text="Stick Header", fontSize = 42.sp, modifier = Modifier.background(Blue))
        }
        item {
            Text(text="title for item", fontSize = 34.sp)
        }
        items(itemList){
                item -> MyCustomItem(itemTitle = item)
        }
    }
}

@Composable
fun myLazyRow() {
    val itemList = listOf<String>("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1",
        "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    LazyRow  {
        item {
            Text(text="title for item", fontSize = 34.sp)
        }
        items(itemList){
                item -> MyCustomItem(itemTitle = item)
        }
    }
}

//@Composable
//fun MyCustomItem(itemTitle: String) {
//    Row(
//        modifier = Modifier.padding(8.dp).fillMaxSize(),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(text= itemTitle, fontSize = 42.sp, modifier = Modifier.background(Green))
//    }
//}

@Composable
fun MyCustomItem(itemTitle: String) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.padding(8.dp).fillMaxSize().pointerInput(Unit){
            detectTapGestures (
                onDoubleTap = {
                    Toast.makeText(context, "You double tap $itemTitle", Toast.LENGTH_SHORT).show()
                },
                onTap = {
                    Toast.makeText(context, "You Single Tap $itemTitle", Toast.LENGTH_SHORT).show()
                }
            )

        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text= itemTitle, fontSize = 42.sp, modifier = Modifier.background(Green)
//            .clickable {
//            Toast.makeText(context, "You click $itemTitle", Toast.LENGTH_SHORT).show()
//        }
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AppContent() {
//
//    Row (
//        modifier = Modifier.horizontalScroll(rememberScrollState())
//    ) {
//        Image(painter = painterResource(id = R.drawable.pic1), contentDescription = "Image", contentScale = ContentScale.FillBounds)
//        Image(painter = painterResource(id = R.drawable.pic2), contentDescription = "Image", contentScale = ContentScale.FillBounds)
//        Image(painter = painterResource(id = R.drawable.pic3), contentDescription = "Image", contentScale = ContentScale.FillBounds)
//    }
//}

//    Column(
//        modifier = Modifier.verticalScroll(rememberScrollState())
//    ) {
//        Image(painter = painterResource(id = R.drawable.pic1), contentDescription = "Image", contentScale = ContentScale.FillBounds)
//        Image(painter = painterResource(id = R.drawable.pic2), contentDescription = "Image", contentScale = ContentScale.FillBounds)
//        Image(painter = painterResource(id = R.drawable.pic3), contentDescription = "Image", contentScale = ContentScale.FillBounds)
//    }




