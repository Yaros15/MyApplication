package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.AppCardRepoImpl
import com.example.myapplication.domain.AppCardRepo
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun AppDetailsContent(
    modifier: Modifier = Modifier
) {
    val appCardRepo: AppCardRepo = remember { AppCardRepoImpl() }

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        Toolbar(modifier = Modifier.fillMaxWidth())

        Spacer(Modifier.height(8.dp))

        AppsListVertical(
            appsListForStore = appCardRepo.getAllCardsApp(),
            modifier = modifier
        )

    }

}

@Preview
@Composable
fun AppDetailsContentPreview(){
    MyApplicationTheme {
        AppDetailsContent()
    }
}