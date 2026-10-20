package com.example.myapplication.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.data.AppCard
import com.example.myapplication.data.AppCardRepoImpl
import com.example.myapplication.domain.AppCardRepo

@Composable
fun RootNavHost (){

    val navController = rememberNavController()
    val appCardRepo: AppCardRepo = remember { AppCardRepoImpl() }
    val appsListForStore = appCardRepo.getAllCardsApp()

    NavHost(
        navController = navController,
        startDestination = HomeDestination
    ){

        composable<HomeDestination> {
            AppDetailsScreen(
                appsListForStore = appsListForStore,
                onClickTheCard = {app: AppCard ->
                    navController.navigate(AppItemCardDestination(appId = app.id))}
            )
        }

        composable<AppItemCardDestination> {backStackEntry ->
            val routeInfo = backStackEntry.toRoute<AppItemCardDestination>()
            val curApp = appCardRepo.findById(routeInfo.appId)

            AppItemCardScreen(
                appCard = curApp,
                appsListForStore = appsListForStore,
                onBackClick = {navController.popBackStack()},
                onClickTheCard = {app: AppCard ->
                    navController.navigate(AppItemCardDestination(appId = app.id))}
            )

        }

    }

}