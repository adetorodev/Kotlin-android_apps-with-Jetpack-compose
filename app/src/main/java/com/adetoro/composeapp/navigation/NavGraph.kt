package com.adetoro.composeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.adetoro.composeapp.navigation.NavRoute.Profile.id
import com.adetoro.composeapp.navigation.NavRoute.Profile.showDetails
import com.adetoro.composeapp.screens.HomeScreen
import com.adetoro.composeapp.screens.ProfileScreen
import com.adetoro.composeapp.screens.SettingScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Home.path){
        addHomeScreen(navController, this)
        addProfileScreen(navController, this)
        addSettingsScreen(navController, this)
    }
}

fun addHomeScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Home.path
    ){
        HomeScreen(
            navigateToProfile = {
                id, showDetails -> navController.navigate(
                    NavRoute.Profile.path.plus("/$id/$showDetails")
                )
            },
            navigateToSetting = {navController.navigate(NavRoute.Settings.path) }
        )
    }
}

fun addProfileScreen (navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path.plus("/{id}/{showDetails}"),
        arguments = listOf(
            navArgument(id) { type = NavType.IntType },
            navArgument(showDetails) { type = NavType.BoolType }
        )
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments

        ProfileScreen(
            id = args?.getInt(NavRoute.Profile.id)!!,
            showDetails = args.getBoolean(NavRoute.Profile.showDetails),
            navigateToSetting = { navController.navigate(NavRoute.Settings.path) }
        )
    }
}

fun addSettingsScreen(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Settings.path
    ){
        SettingScreen(
            navigateToHome = { navController.navigate(NavRoute.Home.path) }
        )

    }
}