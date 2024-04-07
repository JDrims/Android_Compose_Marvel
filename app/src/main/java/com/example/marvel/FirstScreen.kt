package com.example.marvel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen(navController = rememberNavController())
}

@Composable
fun FirstScreen(navController : NavHostController) {
    ImageBackground()
    Column {
        HeadingBox()
        ScreenLazyList(navController)
    }
}

@Composable
fun HeadingBox() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(
        modifier = Modifier
            .background(Color(0xFF2B272B))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .background(Color(0xFF2B272B))
                .padding(top = 30.dp, bottom = 20.dp)
                .width(screenWidth / 2.81F),
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = "Marvel logo",
            contentScale = ContentScale.Fit
        )
        Text(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 11.dp),
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(800),
                fontSize = 28.sp,
                color = Color(0xFFFFFFFF),
            ),
            text = "Choose your hero"
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScreenLazyList(navController : NavHostController) {
    val state = rememberLazyListState()
    val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
    val flingBehavior = rememberSnapFlingBehavior(snappingLayout)
    val url1 = UrlImage(
        "https://iili.io/JMnAfIV.png",
        "Deadpool",
        "Please don’t make the super suit green...or animated!"
    )
    val url2 = UrlImage(
        "https://s3-alpha-sig.figma.com/img/d6ff/6e53/06e9a778c50e17ebd04b812b3a8258ef?Expires=1713139200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=fYvGG0~UTBiA3-JsVkB4O2Eb57QmOR926aw0BiKIu0cyeF8PiYFPAfFxD~Ft1vV3BobRheeZq3pl-Q6ezOnE0ZJEG1XUY~WHor9MuZHuPULaUhNVdrbf1hjFy~4CcOt7s2dLj6Gbk-2oFvft6GzhTUuaExQYytkIlxuuSb6FjPVpIt1aiSkDfXLD9DkpEDirohQ5RXQE8LUGzVHYSUNQ53~v3m~nPtsZImaTPWx-vnZxmHFM-S8zjgoLXoELudqIvJnM0GvX~gqQ7vP3DfnQEpgoHXWTbGyeWHfgBN-2SI3F31qx2klM3l81vFQz-1PG4XsoLD0-RayquVD8FEGyPw__",
        "Iron Man",
        "I AM IRON MAN"
    )
    val url3 = UrlImage(
        "https://iili.io/JMnuyB9.png",
        "Spider Man",
        "In iron suit"
    )
    val listUrl: List<UrlImage> = listOf(url1, url2, url3)
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .background(Color(0x00FFFFFF)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(-25.dp),
        contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
        state = state,
        flingBehavior = flingBehavior,
    ) {
        items(listUrl) {

        }
    }
}