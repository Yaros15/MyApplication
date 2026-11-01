package com.example.myapplication.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.repository.AppCardRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appCardRepo: AppCardRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow<AppMainUIState>(AppMainUIState.Loading)
    val uiState: StateFlow<AppMainUIState> = _uiState.asStateFlow()

    private val _events = Channel<String>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _uiState.value = AppMainUIState.Loading
            try {
                val apps = appCardRepo.getAllCardsApp()
                _events.send("Привет!")
                _uiState.value = AppMainUIState.Content(apps)
            } catch (e: Exception) {
                _uiState.value = AppMainUIState.Error(e.message ?: "Ошибка загрузки")
            }
        }
    }

    fun showSnackbar(message: String) {
        viewModelScope.launch {
            _events.send(message)
        }
    }
}