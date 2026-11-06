package com.example.myapplication.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppCardDto(
    val id: String,
    val name: String,
    val description: String,
    @SerialName("category") val categoryApp: String,
    val iconUrl: String,

    val developer: String? = null,
    val ageRating: Int? = null,
    val size: Double? = null,
    val screenshotUrlList: List<String>? = emptyList()
)