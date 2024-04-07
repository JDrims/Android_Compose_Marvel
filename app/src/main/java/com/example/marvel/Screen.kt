package com.example.marvel

sealed class Screen(val route : String) {
    object FirstScreen : Screen("FirstScreen")
    object SecondScreen : Screen("SecondScreen")
}