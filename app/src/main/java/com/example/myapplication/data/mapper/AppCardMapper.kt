package com.example.myapplication.data.mapper

import com.example.myapplication.domain.domainModel.AppCard
import com.example.myapplication.data.dto.AppCardDto
import javax.inject.Inject

class AppCardMapper @Inject constructor() {

    fun toDomain(dto: AppCardDto): AppCard = AppCard(
        id =dto.id,
        iconUrl =dto.iconUrl,
        name =dto.name,
        description =dto.description,
        categoryApp =dto.categoryApp,
    )

    fun toDTO(domain: AppCard): AppCardDto = AppCardDto(
        id =domain.id,
        iconUrl =domain.iconUrl,
        name =domain.name,
        description =domain.description,
        categoryApp =domain.categoryApp,
    )

}