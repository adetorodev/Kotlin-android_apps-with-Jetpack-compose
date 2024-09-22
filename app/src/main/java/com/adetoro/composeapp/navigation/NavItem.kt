package com.adetoro.composeapp.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import com.adetoro.composeapp.navigation.NavItem.Home.title

sealed class NavItem {
    object Home: Item (NavRoute.Home.path.toString(),
         "Home", Icons.Default.Home)

    object Profile:
            Item(NavRoute.Profile.path.toString(),
                "Profile", Icons.Default.Person)

    object Settings:
            Item(NavRoute.Settings.path.toString(),
                "Settings", Icons.Default.Settings)
}

