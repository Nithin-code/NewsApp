package com.example.newsapp.navigation

sealed class Screens(val route : String) {

    data object DashBoardScreen : Screens(route = "Dashboard_screen")



}