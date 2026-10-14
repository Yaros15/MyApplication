package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
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
    val appCardRepo: AppCardRepo = AppCardRepoImpl()

    Column(
        modifier = modifier
    ) {

        Toolbar(modifier = modifier)

        Spacer(Modifier.height(8.dp))

        AppsList(
            AppsListForStor = appCardRepo.getAllCardsApp(),
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