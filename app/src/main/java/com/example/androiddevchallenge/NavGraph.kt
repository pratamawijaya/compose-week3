/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
            WelcomeScreen(onWelcomeCompleteListener = actions.actionStartToLogin)
        }

        composable(MainDestinations.LOGIN) {
            LoginScreen(
                loginSuccessListener = actions.actionLoginToHome
            )
        }

        composable(MainDestinations.HOME) {
            HomeScreen()
        }
    }
}

class MainActions(navController: NavController) {

    val actionStartToLogin: (Int) -> Unit = {
        navController.navigate(MainDestinations.LOGIN)
    }

    val actionLoginToHome: () -> Unit = {
        navController.navigate(MainDestinations.HOME)
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
