package com.example.myapplication.domain.repository

import com.example.myapplication.domain.domainModel.AppCard


interface AppCardRepo {

    suspend fun getAllCardsApp(): List<AppCard>

    suspend fun findById(id: String): AppCard

}