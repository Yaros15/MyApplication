package com.example.myapplication.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.domain.domainModel.AppCardDomain
import com.example.myapplication.data.repositoriImpl.AppCardRepoImpl
import com.example.myapplication.domain.repository.AppCardRepo
import com.example.myapplication.presentation.ui.AppDetailsScreen
import com.example.myapplication.presentation.ui.AppItemCardScreen

@Composable
fun RootNavHost (){

    val navController = rememberNavController()
    val appCardRepo: AppCardRepo = AppCardRepoImpl()

    NavHost(
        navController = navController,
        startDestination = HomeDestination
    ){

        composable<HomeDestination> {
            AppDetailsScreen(
                onClickTheCard = { app: AppCardDomain ->
                    navController.navigate(AppItemCardDestination(appId = app.id))
                }
            )
        }

        composable<AppItemCardDestination> {backStackEntry ->
            val routeInfo = backStackEntry.toRoute<AppItemCardDestination>()
            val curApp = appCardRepo.findById(routeInfo.appId)

            AppItemCardScreen(
                appCardDomain = curApp,
                onBackClick = { navController.popBackStack() },
                onClickTheCard = { app: AppCardDomain ->
                    navController.navigate(AppItemCardDestination(appId = app.id))
                }
            )

        }

    }

}