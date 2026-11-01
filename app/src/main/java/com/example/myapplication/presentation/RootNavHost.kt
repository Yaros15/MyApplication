package com.example.myapplication.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.domain.domainModel.AppCard
import com.example.myapplication.presentation.ui.AppDetailsScreen
import com.example.myapplication.presentation.ui.AppItemCardScreen

@Composable
fun RootNavHost (){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeDestination
    ){

        composable<HomeDestination> {
            AppDetailsScreen(
                onClickTheCard = { app: AppCard ->
                    navController.navigate(AppItemCardDestination(appId = app.id))
                }
            )
        }

        composable<AppItemCardDestination> {backStackEntry ->
            val routeInfo = backStackEntry.toRoute<AppItemCardDestination>()

            AppItemCardScreen(
                appId = routeInfo.appId,
                onBackClick = { navController.popBackStack() },
                onClickTheCard = { app: AppCard ->
                    navController.navigate(AppItemCardDestination(appId = app.id))
                }
            )

        }

    }

}