package com.tabieni.resources.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tabieni.resources.R

// Set of Material typography styles to start with
val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = poppins,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
    )

    val poppins = FontFamily(
        Font(resId = R.font.poppins_black,FontWeight.Black),
        Font(resId = R.font.poppins_bold,FontWeight.Bold),
        Font(resId = R.font.poppins_extra_bold, FontWeight.ExtraBold),
        Font(resId = R.font.poppins_extra_light,FontWeight.ExtraLight),
        Font(resId = R.font.poppins_italic,FontWeight.Normal, FontStyle.Italic),
        Font(resId = R.font.poppins_light,FontWeight.Light),
        Font(resId = R.font.poppins_light_italic,FontWeight.Light,FontStyle.Italic),
        Font(resId = R.font.poppins_medium,FontWeight.Medium),
        Font(resId = R.font.poppins_medium_italic, FontWeight.Medium,FontStyle.Italic),
        Font(resId = R.font.poppins_regular,FontWeight.Normal),
        Font(resId = R.font.poppins_semi_bold_italic, FontWeight.SemiBold,FontStyle.Italic),
        Font(resId = R.font.poppins_semibold, FontWeight.SemiBold),
        Font(resId = R.font.poppins_thin,FontWeight.Thin),
        Font(resId = R.font.poppins_thin_italic,FontWeight.Thin,FontStyle.Italic)
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
