package com.example.myapplication.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.myapplication.domain.domainModel.AppCard
import com.example.myapplication.presentation.viewModel.AppDetailsState
import com.example.myapplication.presentation.viewModel.AppDetailsViewModel

@Composable
fun AppItemCardScreen(
    appId: String,
    onBackClick: () -> Unit,
    onClickTheCard: (AppCard) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppDetailsViewModel = hiltViewModel<AppDetailsViewModel>()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier
                .padding(innerPadding)
        ) {

            Toolbar(onBackClick = onBackClick)

            when (val state = uiState) {

                is AppDetailsState.Loading ->{
                    //
                }

                is AppDetailsState.Error ->{
                    //
                }

                is AppDetailsState.Content -> {

                    val appCardDomain = state.appDetails
                    val storefront = state.storefrontApps

                    AsyncImage(
                        model = appCardDomain.iconUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f) // Соотношение сторон сохранится
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(text = appCardDomain.name)
                    Text(text = appCardDomain.description)
                    Text(text = appCardDomain.categoryApp.name)

                    Spacer(modifier = Modifier.height(24.dp))

                    Showcase(
                        appsListForStore = storefront,
                        onClickTheCard = onClickTheCard
                    )
                }

            }
        }
    }
}