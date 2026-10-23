package com.example.myapplication.presentation

import com.example.myapplication.data.AppCard

data class MainUIState(
    val appsListForStore: List<AppCard> = emptyList(),
    val snackbarMessage : String? = ""
)