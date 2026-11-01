package com.example.myapplication.data.local

import com.example.myapplication.data.dto.AppCardDto

interface AppDetailsDao {

    fun getAllCardsApp(): List<AppCardDto>

    fun findById(id: String): AppCardDto

}