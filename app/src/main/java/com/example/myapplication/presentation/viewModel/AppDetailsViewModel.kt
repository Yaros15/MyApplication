package com.example.myapplication.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.repository.AppCardRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    private var installJob: Job? = null

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
                    storefrontApps = allApps.take(9),
                    installState = InstallState.NotInstalled
                )
            } catch (e: Exception) {
                _uiState.value = AppDetailsState.Error(e.message ?: "Неизвестная ошибка")
            }
        }
    }

    fun onInstallClick() {
        val current = _uiState.value
        if (current !is AppDetailsState.Content) return

        if (current.installState is InstallState.Installing) {
            installJob?.cancel()
            _uiState.update {
                (it as AppDetailsState.Content).copy(installState = InstallState.NotInstalled)
            }
        } else {
            installJob = viewModelScope.launch {
                emulateInstall()
            }
        }
    }

    private suspend fun emulateInstall() {
        for (progress in 0..100 step 5) {
            delay(150)

            _uiState.update { state ->
                if (state is AppDetailsState.Content) {
                    state.copy(installState = InstallState.Installing(progress))
                } else state
            }
        }

        _uiState.update { state ->
            if (state is AppDetailsState.Content) {
                state.copy(installState = InstallState.Installed)
            } else state
        }
    }

}