package com.example.myapplication.domain.repository

import com.example.myapplication.domain.domainModel.AppCardDomain

interface AppCardRepo {

    fun getAllCardsApp(): List<AppCardDomain>

    fun findById(id: String): AppCardDomain

}