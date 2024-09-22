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
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navItems = listOf(NavItem.Home, NavItem.Profile, NavItem.Settings)
//    var selectedItem by rememberSaveable {
//        mutableStateOf(0)
//    }

    // Synchronization between NavigationBar and current screen

    val navBackStackEntery by navController.currentBackStackEntryAsState()

    // Current Route
    val currentRoute = navBackStackEntery?.destination?.route

    var selectedItem = navItems.indexOfFirst { it.path == currentRoute}

    var selectedNavItem by rememberSaveable {
        mutableStateOf(if (selectedItem >0 ) selectedItem else 0)
    }


    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedNavItem = index

                    // handling the navigation to Profile Screen
//                    Passing arguments bet5ween the screens

                    val route = if(item.path == NavRoute.Profile.path){
                        NavRoute.Profile.path.plus("/77/true")
                    }else{
                        item.path
                    }


                    navController.navigate(route){
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