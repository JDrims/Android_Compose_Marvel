package com.example.marvel

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen(navController = rememberNavController())
}

@Composable
fun FirstScreen(navController : NavHostController) {

}