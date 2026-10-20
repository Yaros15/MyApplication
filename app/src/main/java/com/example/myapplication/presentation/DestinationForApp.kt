package com.example.myapplication.presentation

import kotlinx.serialization.Serializable

@Serializable
data object HomeDestination
@kotlinx.serialization.Serializable
data class AppItemCardDestination(val appId: String)