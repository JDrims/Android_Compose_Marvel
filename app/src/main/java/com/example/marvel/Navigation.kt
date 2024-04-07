package com.example.marvel

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Navigation(navController : NavHostController) {
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
        composable(Screen.FirstScreen.route) {
            FirstScreen(navController)
        }
        composable(
            Screen.SecondScreen.route + "/{url}/{nameUrl}/{descriptionUrl}",
            arguments = listOf(
                navArgument(
                    "url"
                ) {
                    type = NavType.StringType
                },
                navArgument(
                    "nameUrl"
                ) {
                    type = NavType.StringType
                },
                navArgument(
                    "descriptionUrl"
                ) {
                    type = NavType.StringType
                }
            )
        ) {backStackEntry ->
            SecondScreen(navController, backStackEntry )
        }
    }
}
