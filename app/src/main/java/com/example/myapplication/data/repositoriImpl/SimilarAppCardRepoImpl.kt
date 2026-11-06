package com.example.myapplication.data.repositoriImpl

import com.example.myapplication.data.dto.SimilarAppCardDto
import com.example.myapplication.data.local.AppDetailsDao
import com.example.myapplication.data.mapper.SimilarAppCardMapper
import com.example.myapplication.domain.domainModel.SimilarAppCard
import com.example.myapplication.domain.repository.SimilarAppCardRepo
import javax.inject.Inject
import kotlin.collections.map

class SimilarAppCardRepoImpl @Inject constructor(
    private val appDetailsDao: AppDetailsDao,
    private val similarAppCardMapper: SimilarAppCardMapper
): SimilarAppCardRepo {

    override suspend fun getAllCardsApp(): List<SimilarAppCard> {
        val curSimilarAppCardDtoLists: List<SimilarAppCardDto> = appDetailsDao.getAllCardsApp()
        val similarAppCardLists: List<SimilarAppCard> = curSimilarAppCardDtoLists.map{
                dto -> similarAppCardMapper.toDomain(dto)
        }
        return similarAppCardLists
    }

    override suspend fun findById(id: String): SimilarAppCard {
        val curSimilarAppCardDto: SimilarAppCardDto = appDetailsDao.findById(id)
        val similarAppCard: SimilarAppCard = similarAppCardMapper.toDomain(curSimilarAppCardDto)
        return similarAppCard
    }

}