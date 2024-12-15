package com.iagoaf.remindapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iagoaf.remindapp.core.ui.theme.RemindAppTheme
import com.iagoaf.remindapp.modules.auth.presentation.LoginScreen
import com.iagoaf.remindapp.modules.splash.presentation.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemindAppTheme {
                NavigationStack()
            }
        }
    }
}

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.Splash.route
    ) {
        composable(route = AppScreens.Splash.route) {
            SplashScreen(navController)
        }
        composable(
            route = AppScreens.Login.route + "?text={text}",
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            LoginScreen(navController)
        }
    }
}
sealed class AppScreens(val route: String) {
    object Splash: AppScreens("splash_screen")
    object Login: AppScreens("login_screen")
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RemindAppTheme {
        SplashScreen(navController = rememberNavController())
    }
}