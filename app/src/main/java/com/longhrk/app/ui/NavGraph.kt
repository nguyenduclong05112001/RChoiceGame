package com.longhrk.app.ui

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.longhrk.app.ui.event.NavEvent
import com.longhrk.app.ui.screen.HomeScreen
import com.longhrk.app.ui.screen.OtherScreen
import com.longhrk.app.ui.screen.SplashScreen
import com.longhrk.app.ui.viewmodel.GameViewModel

@Composable
fun NavGraph(eventHandler: EventHandler, navController: NavHostController) {
    val startDestination = NavTarget.Splash.route

    //    init viewModels
    val activityScope = LocalContext.current as ComponentActivity
    val gameViewModel = hiltViewModel<GameViewModel>(activityScope)

    NavHost(navController, startDestination) {
        composable(NavTarget.Splash.route) {
            SplashScreen {
                eventHandler.postNavEvent(
                    event = NavEvent.ActionWithPopUp(
                        target = NavTarget.Home,
                        popupTarget = NavTarget.Splash,
                        inclusive = true
                    )
                )
            }
        }

        composable(NavTarget.Home.route) {
            HomeScreen(
                gameViewModel = gameViewModel
            )
        }

        composable(NavTarget.Other.route) {
            OtherScreen(
                onClick = { }
            )
        }
    }
}