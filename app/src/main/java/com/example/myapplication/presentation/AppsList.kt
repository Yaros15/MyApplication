package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.data.AppCard
import com.example.myapplication.data.CategoryApp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun AppsList(
    AppsListForStor: List<AppCard>,
    modifier: Modifier = Modifier
) {

    Column(modifier) {

        VerticalPager(
            modifier = Modifier.fillMaxHeight(),
            pageSpacing = 8.dp,
            state = rememberPagerState{AppsListForStor.size}
        ) { index ->
            AsyncImage(
                model = AppsListForStor[index].iconUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f) // Соотношение сторон сохранится
                    .clip(RoundedCornerShape(8.dp))
            )
            Text(modifier=modifier, text = AppsListForStor[index].name)
            Text(modifier=modifier, text = AppsListForStor[index].description)
            Text(modifier=modifier, text = AppsListForStor[index].categoryApp.name)

        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenshotsListPreview(){
    MyApplicationTheme {
        AppsList(listOf(AppCard("https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp","Герои меча и магии","Стратегическая игра", CategoryApp.GAME)))
    }
}