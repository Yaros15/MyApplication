package com.example.myapplication.domain.domainModel

import com.example.myapplication.data.dto.CategoryApp

data class SimilarAppCard(
    val id: String,
    val iconUrl: String,
    val name: String,
    val description: String,
    val categoryApp: CategoryApp,
)
