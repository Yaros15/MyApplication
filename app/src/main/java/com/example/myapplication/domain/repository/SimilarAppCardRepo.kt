package com.example.myapplication.domain.repository

import com.example.myapplication.domain.domainModel.SimilarAppCard

interface SimilarAppCardRepo {

    suspend fun getAllCardsApp(): List<SimilarAppCard>

    suspend fun findById(id: String): SimilarAppCard

}