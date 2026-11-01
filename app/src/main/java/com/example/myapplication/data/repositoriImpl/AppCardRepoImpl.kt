package com.example.myapplication.data.repositoriImpl

import com.example.myapplication.data.dto.AppCardDto
import com.example.myapplication.data.local.AppDetailsDao
import com.example.myapplication.data.mapper.AppCardMapper
import com.example.myapplication.domain.domainModel.AppCard
import com.example.myapplication.domain.repository.AppCardRepo
import javax.inject.Inject
import kotlin.collections.map

class AppCardRepoImpl @Inject constructor(
    private val appDetailsDao: AppDetailsDao,
    private val appCardMapper: AppCardMapper
): AppCardRepo{

    override fun getAllCardsApp(): List<AppCard> {
        val curAppCardDtoLists: List<AppCardDto> = appDetailsDao.getAllCardsApp()
        val appCardLists: List<AppCard> = curAppCardDtoLists.map{
                dto -> appCardMapper.toDomain(dto)
        }
        return appCardLists
    }

    override fun findById(id: String): AppCard {
        val curAppCardDto: AppCardDto = appDetailsDao.findById(id)
        val appCard: AppCard = appCardMapper.toDomain(curAppCardDto)
        return appCard
    }

}