package com.adetoro.composeapp.navigation

import android.graphics.drawable.Icon
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navItems = listOf(NavItem.Home, NavItem.Profile, NavItem.Settings)
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.path){
                        navController.graph.startDestinationRoute?.let {
                                route -> popUpTo(route){
                            saveState = true
                        }
                            launchSingleTop = true
                            restoreState = true
                        }

                    }
                },
                icon = {
                    Icon(imageVector = item.icon,
                        contentDescription = item.title)
                       },
                label = {Text(text=item.title)}
            )
        }

    }
}