package com.example.myapplication.presentation.viewModel

import com.example.myapplication.domain.domainModel.AppCardDomain

data class MainUIState(
    val appsListForStore: List<AppCardDomain> = emptyList(),
    val snackbarMessage : String? = ""
)