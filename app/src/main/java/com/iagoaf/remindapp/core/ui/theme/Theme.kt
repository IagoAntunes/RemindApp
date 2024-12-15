package com.iagoaf.remindapp.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.iagoaf.remindapp.R

private val DarkColorScheme = darkColorScheme(
    primary = AppColors.redLight,
    secondary = AppColors.blueLight,
    tertiary = AppColors.gray200
)

private val LightColorScheme = lightColorScheme(
    primary = AppColors.redBase,
    secondary = AppColors.blueBase,
    tertiary = AppColors.gray100
)

val nunitoSansfontFamily = FontFamily(
    Font(R.font.nunitosans),
    Font(R.font.nunitosans_extrabold, FontWeight.ExtraBold),
    Font(R.font.nunitosans_regular, FontWeight.Medium),
    Font(R.font.nunitosans_semibold, FontWeight.SemiBold),
)

@Composable
fun RemindAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}