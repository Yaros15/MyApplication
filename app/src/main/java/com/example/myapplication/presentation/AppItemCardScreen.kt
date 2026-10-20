package com.example.myapplication.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppItemCardScreen(appCardId: String) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        AppItemCard(
            appCardId = appCardId,
            modifier = Modifier.padding(innerPadding)
        )
    }
}