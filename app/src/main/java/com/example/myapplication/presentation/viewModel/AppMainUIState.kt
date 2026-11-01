package com.example.myapplication.presentation.viewModel

import com.example.myapplication.domain.domainModel.AppCard

interface AppMainUIState {

    data object Loading : AppMainUIState
    data class Content(val appsListForStore: List<AppCard>) : AppMainUIState
    data class Error(val message: String) : AppMainUIState

}