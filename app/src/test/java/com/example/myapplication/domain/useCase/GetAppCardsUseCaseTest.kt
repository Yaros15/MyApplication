package com.example.myapplication.domain.useCase

import com.example.myapplication.domain.domainModel.AppCard
import com.example.myapplication.domain.repository.AppCardRepo
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetAppCardsUseCaseTest {

    private lateinit var repository: AppCardRepo
    private lateinit var useCase: GetAppCardsUseCase

    private val testCard = AppCard("1", "url", "Test App", "desc", "cat")

    @Before
    fun setUp() {
        repository = mockk()
        useCase = GetAppCardsUseCase(repository)
    }

    @Test
    fun `invoke should return list from repository`() = runTest {

        val expectedList = listOf(testCard)
        coEvery { repository.getAllCardsApp() } returns expectedList

        val result = useCase()

        assertEquals(expectedList, result)
        coVerify(exactly = 1) { repository.getAllCardsApp() }
    }

    @Test
    fun `invoke should return empty list when repository returns empty`() = runTest {

        coEvery { repository.getAllCardsApp() } returns emptyList()

        val result = useCase()

        assertTrue(result.isEmpty())
        coVerify(exactly = 1) { repository.getAllCardsApp() }
    }

    @Test(expected = Exception::class)
    fun `invoke should propagate exception from repository`() = runTest {

        coEvery { repository.getAllCardsApp() } throws RuntimeException("Network Error")

        useCase() // Должно выбросить исключение
    }
}