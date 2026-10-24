package com.example.myapplication.data.mapper

import com.example.myapplication.domain.domainModel.AppCardDomain
import com.example.myapplication.data.dto.AppCardDto

class AppCardMapper {

    fun toDomain(dto: AppCardDto): AppCardDomain = AppCardDomain(
        id =dto.id,
        iconUrl =dto.iconUrl,
        name =dto.name,
        description =dto.description,
        categoryApp =dto.categoryApp,
    )

    fun toDTO(domain: AppCardDomain): AppCardDto = AppCardDto(
        id =domain.id,
        iconUrl =domain.iconUrl,
        name =domain.name,
        description =domain.description,
        categoryApp =domain.categoryApp,
    )

}