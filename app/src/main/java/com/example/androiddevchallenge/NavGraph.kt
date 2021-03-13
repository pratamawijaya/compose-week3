package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.home.HomeScreen
import com.example.androiddevchallenge.ui.screens.login.LoginScreen
import com.example.androiddevchallenge.ui.screens.welcome.WelcomeScreen

object MainDestinations {
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val HOME = "home"
}


@Composable
fun NavGraph(startDestination: String = MainDestinations.WELCOME) {
    val navController = rememberNavController()
    val actions = remember(navController) {
        MainActions(navController)
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(MainDestinations.WELCOME) {
            WelcomeScreen(
                welcomeScreenComplete = actions.actionStartToLogin
            )
        }

        composable(MainDestinations.LOGIN) {
            LoginScreen(
                loginSuccess = actions.actionLoginToHome
            )
        }

        composable(MainDestinations.HOME) {
            HomeScreen()
        }

    }
}

class MainActions(navController: NavController) {

    val actionStartToLogin: () -> Unit = {
        navController.navigate(MainDestinations.LOGIN)
    }

    val actionLoginToHome: () -> Unit = {
        navController.navigate(MainDestinations.HOME)
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}