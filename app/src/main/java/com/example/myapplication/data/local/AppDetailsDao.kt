package com.example.myapplication.data.local

import com.example.myapplication.data.dto.SimilarAppCardDto

interface AppDetailsDao {

    fun getAllCardsApp(): List<SimilarAppCardDto>

    fun findById(id: String): SimilarAppCardDto

}