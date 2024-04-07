package com.example.marvel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen(navController = rememberNavController(), null)
}

@Composable
fun SecondScreen(navController: NavHostController, navBackStackEntry: NavBackStackEntry?) {
    val url = navBackStackEntry?.arguments?.getString("url")
    val nameUrl = navBackStackEntry?.arguments?.getString("nameUrl")
    val descriptionUrl = navBackStackEntry?.arguments?.getString("descriptionUrl")
    val listUrl = UrlImage(
        url.toString(),
        nameUrl.toString(),
        descriptionUrl.toString()
    )
    ImageBackground()
    Column {
        CardFull(navController, listUrl)
    }
}

@Composable
fun CardFull(navController: NavHostController, listUrl: UrlImage) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF2B272B),
                shape = RoundedCornerShape(size = 10.dp),
            )
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(size = 10.dp)),
            model = listUrl.url,
            contentDescription = listUrl.nameUrl,
            contentScale = ContentScale.Crop,
        )
        Image(
            modifier = Modifier
                .statusBarsPadding()
                .padding(
                    top = 16.dp, start = 16.dp
                )
                .width(28.dp)
                .height(32.dp)
                .clickable {
                    navController.navigate(Screen.FirstScreen.route)
                },
            painter = painterResource(id = R.drawable.vector),
            contentDescription = listUrl.nameUrl
        )
        Column(
            modifier = Modifier.padding(
                top = screenHeight / 1.17F, start = 28.dp
            ),
        ) {
            Text(
                modifier = Modifier.padding(
                ),
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(800),
                    fontSize = 32.sp,
                    color = Color(0xFFFFFFFF),
                ),
                text = listUrl.nameUrl,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 15.dp
                    ),
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(800),
                    fontSize = 22.sp,
                    color = Color(0xE6FFFFFF),
                    lineHeight = 30.sp
                ),
                text = listUrl.descriptionUrl,
            )
        }
    }
}