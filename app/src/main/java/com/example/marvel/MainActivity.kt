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
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.marvel.ui.theme.ColorDrawRect
import com.example.marvel.ui.theme.ColorDrawRectRotateL1
import com.example.marvel.ui.theme.ColorDrawRectRotateL2
import com.example.marvel.ui.theme.ColorTransparent
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
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
        systemUiController.setStatusBarColor(ColorTransparent)
        systemUiController.setNavigationBarColor(ColorTransparent)
    }
}

@Composable
fun ImageBackground() {
    Column {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(ColorDrawRect)
            rotate(degrees = 37.56F) {
                drawRect(
                    Brush.linearGradient(
                        listOf(
                            ColorDrawRectRotateL1, ColorDrawRectRotateL2
                        ), Offset(1.0F, 1.0F)
                    ), topLeft = Offset(x = 800F, y = 550F), size = size / 0.9F
                )
            }
        }
    }
}

class UrlImage(
    url: String,
    nameUrl: String,
    descriptionUrl: String,
) {
    val url = url
    val nameUrl = nameUrl
    val descriptionUrl = descriptionUrl
}