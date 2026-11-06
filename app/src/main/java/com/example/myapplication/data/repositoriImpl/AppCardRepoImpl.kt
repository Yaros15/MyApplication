package com.example.myapplication.data.repositoriImpl

import com.example.myapplication.data.dto.AppCardDto
import com.example.myapplication.data.local.AppCardApi
import com.example.myapplication.data.mapper.AppCardMapper
import com.example.myapplication.domain.repository.AppCardRepo
import com.example.myapplication.domain.domainModel.AppCard
import javax.inject.Inject

class AppCardRepoImpl @Inject constructor(
    private val appCardApi: AppCardApi,
    private val appCardMapper: AppCardMapper
): AppCardRepo {

    override suspend fun getAllCardsApp(): List<AppCard> {
        val curAppCardDtoLists: List<AppCardDto> = appCardApi.getCatalog()
        val appCardLists: List<AppCard> = curAppCardDtoLists.map{
                dto -> appCardMapper.toDomain(dto)
        }
        return appCardLists
    }

    override suspend fun findById(id: String): AppCard {
        val curAppCardDto: AppCardDto = appCardApi.getAppCard(id)
        val appCard: AppCard = appCardMapper.toDomain(curAppCardDto)
        return appCard
    }
}