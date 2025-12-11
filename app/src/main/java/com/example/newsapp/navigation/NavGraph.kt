package com.example.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.dashboard.DashBoardScreen
import com.example.newsapp.top_head_lines.view.TopHeadLinesScreen


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
                    navController.navigate(Screens.TopHeadLinesScreen.route)
                }
            )
        }

        composable(route = Screens.TopHeadLinesScreen.route){
            TopHeadLinesScreen()
        }

    }

}