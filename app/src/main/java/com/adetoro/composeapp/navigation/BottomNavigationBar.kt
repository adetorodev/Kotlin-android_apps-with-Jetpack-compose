package com.adetoro.composeapp.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navItems = listOf(NavItem.Home, NavItem.Profile, NavItem.Settings)
    val selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar {
        navItems.forEachIndexed { index, item ->

        }

    }
}