package com.example.myapplication.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.repository.AppCardRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val repository: AppCardRepo,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val appId: String = checkNotNull(savedStateHandle["appId"])

    private val _uiState = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val uiState: StateFlow<AppDetailsState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = AppDetailsState.Loading
            try {
                val app = repository.findById(appId)
                val allApps = repository.getAllCardsApp()

                _uiState.value = AppDetailsState.Content(
                    appDetails = app,
                    storefrontApps = allApps.take(9)
                )
            } catch (e: Exception) {
                _uiState.value = AppDetailsState.Error(e.message ?: "Неизвестная ошибка")
            }
        }
    }
}