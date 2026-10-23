package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.AppCardRepoImpl
import com.example.myapplication.domain.AppCardRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(): ViewModel() {

    private val appCardRepo: AppCardRepo = AppCardRepoImpl()

    private val _uiState = MutableStateFlow(MainUIState())

    val uiState: StateFlow<MainUIState> = _uiState.asStateFlow()

    init {
        loadData()
        showSnackbar()
    }

    fun loadData(){
        _uiState.value = _uiState.value.copy(
            appsListForStore = appCardRepo.getAllCardsApp()
        )
    }

    fun showSnackbar () {
        _uiState.update { uiState ->
            uiState.copy(
                snackbarMessage = "Привет!",
            )
        }
    }

    fun clearSnackbarMessage () {
        _uiState.update { uiState ->
            uiState.copy(
                snackbarMessage = null,
            )
        }
    }

}