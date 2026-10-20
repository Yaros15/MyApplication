package com.example.myapplication.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

//const val HOME_DESTINATION = "home"

@Serializable
data object HomeDestination
@Serializable
data class AppItemCardDestination(val appId: String)

@Composable
fun RootNavHost (){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeDestination
    ){

        composable<HomeDestination> { AppDetailsScreen() }

        composable<AppItemCardDestination> {backStackEntry ->
            val routeInfo = backStackEntry.toRoute<AppItemCardDestination>()
            AppItemCardScreen(routeInfo.appId)
        }

    }

}