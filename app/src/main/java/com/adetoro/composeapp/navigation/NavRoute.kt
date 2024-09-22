package com.adetoro.composeapp.navigation

sealed class NavRoute(val path: String) {

    object Home: NavRoute("home")

    object Profile: NavRoute("profile"){

        fun createRoute(id: Int, showDetails: Boolean): String{
            return "profile/$id/$showDetails"
        }

    }

    object Settings: NavRoute("settings")

}