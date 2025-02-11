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
import com.iagoaf.remindapp.modules.home.presentation.screen.HomeScreen
import com.iagoaf.remindapp.modules.myRecipes.presentation.MyRecipesScreen
import com.iagoaf.remindapp.modules.newRecipe.presentation.NewRecipeScreen
import com.iagoaf.remindapp.modules.splash.presentation.SplashScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
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
        composable(route = AppScreens.Home.route){
            HomeScreen(navController)
        }
        composable(route = AppScreens.MyRecipes.route){
            MyRecipesScreen(navController)
        }
        composable(route = AppScreens.NewRecipe.route){
            NewRecipeScreen(navController)
        }
    }
}
sealed class AppScreens(val route: String) {
    object Splash: AppScreens("splash_screen")
    object Login: AppScreens("login_screen")
    object Home: AppScreens("home_screen")
    object MyRecipes: AppScreens("my_recipes_screen")
    object NewRecipe: AppScreens("new_recipe_screen")
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RemindAppTheme {
        SplashScreen(navController = rememberNavController())
    }
}