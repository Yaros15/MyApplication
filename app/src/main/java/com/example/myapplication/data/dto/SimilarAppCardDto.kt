package com.example.myapplication.data.dto

data class SimilarAppCardDto(
    val id: String,
    val iconUrl: String,
    val name: String,
    val description: String,
    val categoryApp: CategoryApp,
)