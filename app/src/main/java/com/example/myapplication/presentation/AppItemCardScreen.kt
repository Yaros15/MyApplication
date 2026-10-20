package com.example.myapplication.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.data.AppCard

@Composable
fun AppItemCardScreen(
    appCard: AppCard,
    appsListForStore: List<AppCard>,
    onBackClick: () -> Unit,
    onClickTheCard: (AppCard) -> Unit,
    modifier: Modifier = Modifier
) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {

            Toolbar(onBackClick = onBackClick)

            AsyncImage(
                model = appCard.iconUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f) // Соотношение сторон сохранится
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(Modifier.height(16.dp))
            Text(text = appCard.name)
            Text(text = appCard.description)
            Text(text = appCard.categoryApp.name)

            Spacer(modifier = Modifier.height(24.dp))

            Showcase(
                appsListForStore = appsListForStore,
                onClickTheCard = onClickTheCard
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}