package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.data.AppCard
import com.example.myapplication.data.CategoryApp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun AppDetailsScreen (
    appsListForStore: List<AppCard>,
    onClickTheCard: (app: AppCard) -> Unit,
    modifier: Modifier = Modifier
){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            appsListForStore.forEach { appsListForStoreItem ->
                item {
                    AppItemCard(
                        appCard = appsListForStoreItem,
                        onClickTheCard = {onClickTheCard(appsListForStoreItem)})
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppDetailsScreenPreview(){
    MyApplicationTheme {
        AppDetailsScreen(listOf(AppCard("1", "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp","Герои меча и магии","Стратегическая игра", CategoryApp.GAME)),
            onClickTheCard = {})
    }
}