package com.example.myapplication.domain.useCase

import com.example.myapplication.domain.domainModel.AppCard
import com.example.myapplication.domain.repository.AppCardRepo
import javax.inject.Inject

class SearchAppCardsUseCase @Inject constructor(
    private val repository: AppCardRepo
) {

    suspend operator fun invoke(query: String): List<AppCard> {
        if (query.isBlank()) {
            return repository.getAllCardsApp()
        }

        val allCards = repository.getAllCardsApp()

        return allCards.filter { card ->
            card.name.contains(query, ignoreCase = true)
        }
    }
}