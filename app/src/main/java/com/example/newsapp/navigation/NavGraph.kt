package com.example.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.dashboard.DashBoardScreen


@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController : NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Screens.DashBoardScreen.route
    ){

        composable(route = Screens.DashBoardScreen.route){
            DashBoardScreen(
                modifier = modifier,
                onItemClicked = {
                    navController
                }
            )
        }

    }

}