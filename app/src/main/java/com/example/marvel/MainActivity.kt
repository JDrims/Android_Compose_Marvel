package com.example.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            ApplySystemBarColors()
            Surface {
                Navigation(navController)
            }
        }
    }
}

@Composable
fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(Color.Transparent)
        systemUiController.setNavigationBarColor(Color.Transparent)
    }
}

@Composable
fun ImageBackground() {
    Column {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(Color(0xFF2B272B))
            rotate(degrees = 37.56F) {
                drawRect(
                    Brush.linearGradient(
                        listOf(
                            Color(0xFF991518), Color(0xFF941419)
                        ), Offset(1.0F, 1.0F)
                    ), topLeft = Offset(x = 800F, y = 550F), size = size / 0.9F
                )
            }
        }
    }
}