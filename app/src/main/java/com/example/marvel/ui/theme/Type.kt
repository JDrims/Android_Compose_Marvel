package com.example.marvel.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val HeadingBoxStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight(800),
    fontSize = 28.sp,
    color = ColorTextWhite,
)

val CardTextNameStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight(800),
    fontSize = 32.sp,
    color = ColorTextWhite,
)

val CardTextDescriptionStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight(800),
    fontSize = 22.sp,
    color = ColorTextWhiteA90p,
    lineHeight = 30.sp
)