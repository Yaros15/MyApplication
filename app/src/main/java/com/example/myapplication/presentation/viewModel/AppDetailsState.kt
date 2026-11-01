package com.example.myapplication.presentation.viewModel

import com.example.myapplication.domain.domainModel.AppCard

sealed interface AppDetailsState {

    data class Error(val message: String) : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppCard,
        val storefrontApps: List<AppCard>
    ) : AppDetailsState

}