package com.iagoaf.remindapp.modules.splash.presentation

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.iagoaf.remindapp.AppScreens
import com.iagoaf.remindapp.R
import com.iagoaf.remindapp.core.ui.theme.AppColors
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(3000L)
        navController.navigate(AppScreens.Login.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.redBase),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.remind_logo),
            contentDescription = "Remind Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(60.dp)
                .width(255.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewSplashScreen() {
    SplashScreen(
        navController = rememberNavController()
    )
}