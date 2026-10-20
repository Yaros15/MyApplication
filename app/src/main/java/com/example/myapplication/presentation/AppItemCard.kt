package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.data.AppCard
import com.example.myapplication.data.AppCardRepoImpl
import com.example.myapplication.data.CategoryApp
import com.example.myapplication.domain.AppCardRepo
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun AppItemCard (
    appCardId: String,
    modifier: Modifier = Modifier
){
    val appCardRepo: AppCardRepo = remember { AppCardRepoImpl() }

    val appCard: AppCard = appCardRepo.findById(appCardId)

    Column(modifier) {
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
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppItemCardPreview(){
    MyApplicationTheme {
        AppItemCard("1")
    }
}