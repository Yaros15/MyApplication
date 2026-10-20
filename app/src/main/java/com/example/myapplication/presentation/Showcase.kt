package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.AppCard

@Composable
fun Showcase (
    appsListForStore: List<AppCard>,
    onClickTheCard: (app: AppCard) -> Unit,
    modifier: Modifier = Modifier
){
    val itemsPerPage = 3
    val pageCount = (appsListForStore.size + itemsPerPage - 1) / itemsPerPage
    val pagerState = rememberPagerState(pageCount = { pageCount })

    Column(modifier = modifier.fillMaxWidth()) {

        Text(
            text = "Витрина",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 16.dp
        ) {
                page ->

            val startIndex = page * itemsPerPage

            val pageApps = appsListForStore.subList(
                startIndex,
                minOf(startIndex + itemsPerPage, appsListForStore.size)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                pageApps.forEach { appsListForStoreItem ->
                    AppItemCard(
                        appCard = appsListForStoreItem,
                        onClickTheCard = {onClickTheCard(appsListForStoreItem)},
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}