package com.example.myapplication.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val HOME_DESTINATION = "home"

@Composable
fun RootNavHost (){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HOME_DESTINATION
    ){

        composable(HOME_DESTINATION) { AppDetailsScreen() }

    }

}