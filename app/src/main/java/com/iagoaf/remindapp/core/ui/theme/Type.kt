package com.iagoaf.remindapp.core.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class AppTypography{
    companion object{
        val heading = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 24.sp,
            fontFamily = nunitoSansfontFamily,
        )
        val subHeading = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 19.2.sp,
            fontFamily = nunitoSansfontFamily,
        )
        val input = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 19.2.sp,
            fontFamily = nunitoSansfontFamily,
        )
        val label = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 16.8.sp,
            fontFamily = nunitoSansfontFamily,
        )
        val body = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 19.6.sp,
            fontFamily = nunitoSansfontFamily,
        )
        val tag = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 14.4.sp,
            fontFamily = nunitoSansfontFamily,
        )
    }
}