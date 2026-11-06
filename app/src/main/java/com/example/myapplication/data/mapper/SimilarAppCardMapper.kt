package com.example.myapplication.data.mapper

import com.example.myapplication.domain.domainModel.SimilarAppCard
import com.example.myapplication.data.dto.SimilarAppCardDto
import javax.inject.Inject

class SimilarAppCardMapper @Inject constructor() {

    suspend fun toDomain(dto: SimilarAppCardDto): SimilarAppCard = SimilarAppCard(
        id =dto.id,
        iconUrl =dto.iconUrl,
        name =dto.name,
        description =dto.description,
        categoryApp =dto.categoryApp,
    )

    suspend fun toDTO(domain: SimilarAppCard): SimilarAppCardDto = SimilarAppCardDto(
        id =domain.id,
        iconUrl =domain.iconUrl,
        name =domain.name,
        description =domain.description,
        categoryApp =domain.categoryApp,
    )

}