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

class SearchAppCardsUseCaseTest {

    private lateinit var repository: AppCardRepo
    private lateinit var useCase: SearchAppCardsUseCase

    private val card1 = AppCard("1", "url1", "Super Game", "desc", "Game")
    private val card2 = AppCard("2", "url2", "Test App", "desc", "Utility")
    private val card3 = AppCard("3", "url3", "Another Game", "desc", "Game")

    private val allCards = listOf(card1, card2, card3)

    @Before
    fun setUp() {
        repository = mockk()
        useCase = SearchAppCardsUseCase(repository)
    }

    @Test
    fun `invoke with blank query should return all cards`() = runTest {

        coEvery { repository.getAllCardsApp() } returns allCards

        val result = useCase("")

        assertEquals(allCards, result)
        coVerify(exactly = 1) { repository.getAllCardsApp() }
    }

    @Test
    fun `invoke with query should filter by name`() = runTest {

        coEvery { repository.getAllCardsApp() } returns allCards

        val result = useCase("Test")

        assertEquals(1, result.size)
        assertEquals("Test App", result[0].name)
        coVerify(exactly = 1) { repository.getAllCardsApp() }
    }

    @Test
    fun `invoke should ignore case when filtering`() = runTest {

        coEvery { repository.getAllCardsApp() } returns allCards

        val result = useCase("GAME") // Ищем "GAME", а в карточках "Game"

        assertEquals(2, result.size)
        assertEquals("Super Game", result[0].name)
        assertEquals("Another Game", result[1].name)
    }

    @Test
    fun `invoke with non-existing query should return empty list`() = runTest {

        coEvery { repository.getAllCardsApp() } returns allCards

        val result = useCase("Nonexistent")

        assertTrue(result.isEmpty())
    }

    @Test
    fun `invoke with partial match should return matching cards`() = runTest {

        coEvery { repository.getAllCardsApp() } returns allCards

        val result = useCase("Game") // Должен найти "Super Game" и "Another Game"

        assertEquals(2, result.size)
    }

    @Test
    fun `invoke with spaces only should return all cards`() = runTest {

        coEvery { repository.getAllCardsApp() } returns allCards

        val result = useCase("   ")

        assertEquals(allCards, result)
    }

    @Test(expected = Exception::class)
    fun `invoke should propagate exception from repository`() = runTest {

        coEvery { repository.getAllCardsApp() } throws RuntimeException("Network Error")

        useCase("Test")
    }
}