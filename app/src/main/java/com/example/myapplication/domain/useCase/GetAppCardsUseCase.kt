package com.example.myapplication.domain.useCase

import com.example.myapplication.domain.domainModel.AppCard
import com.example.myapplication.domain.repository.AppCardRepo
import javax.inject.Inject

class GetAppCardsUseCase @Inject constructor(
    private val repository: AppCardRepo
) {
    suspend operator fun invoke(): List<AppCard> {
        return repository.getAllCardsApp()
    }
}