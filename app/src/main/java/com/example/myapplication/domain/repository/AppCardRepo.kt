package com.example.myapplication.domain.repository

import com.example.myapplication.domain.domainModel.AppCard

interface AppCardRepo {

    fun getAllCardsApp(): List<AppCard>

    fun findById(id: String): AppCard

}