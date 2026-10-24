package com.example.myapplication.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.domain.domainModel.AppCardDomain
import com.example.myapplication.presentation.viewModel.MainUIState
import com.example.myapplication.presentation.viewModel.MainViewModel

@Composable
fun AppDetailsScreen (
    onClickTheCard: (app: AppCardDomain) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
){

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(uiState, snackbarHostState, viewModel)

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState)},
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            uiState.appsListForStore.forEach { appsListForStoreItem ->
                item {
                    AppItemCard(
                        appCardDomain = appsListForStoreItem,
                        onClickTheCard = { onClickTheCard(appsListForStoreItem) })
                }
            }

        }
    }
}

@Composable
private fun ObserveEvents(
    events: MainUIState,
    snackbarHostState: SnackbarHostState,
    viewModel: MainViewModel
) {

    LaunchedEffect(events.snackbarMessage) {
        if (events.snackbarMessage != null) {
            snackbarHostState.showSnackbar( events.snackbarMessage)
            viewModel.clearSnackbarMessage()
        }
    }

}