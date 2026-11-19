package com.example.myapplication.data.repositoriImpl

import com.example.myapplication.data.dto.AppCardDto
import com.example.myapplication.data.local.AppCardApi
import com.example.myapplication.data.mapper.AppCardMapper
import com.example.myapplication.domain.domainModel.AppCard
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class AppCardRepoImplTest {

    private lateinit var api: AppCardApi
    private lateinit var mapper: AppCardMapper
    private lateinit var repository: AppCardRepoImpl

    private val testDto = AppCardDto("1", "url", "name", "desc", "cat")
    private val testDomain = AppCard("1", "url", "name", "desc", "cat")

    @Before
    fun setUp() {
        api = mockk()
        mapper = mockk()
        repository = AppCardRepoImpl(api, mapper)
    }

    @Test
    fun `getAllCardsApp should return list of domain models when api returns data`() = runTest {

        val dtoList = listOf(testDto)

        coEvery { api.getCatalog() } returns dtoList

        coEvery { mapper.toDomain(testDto) } returns testDomain

        val result = repository.getAllCardsApp()

        assertEquals(1, result.size)
        assertEquals(testDomain, result[0])

        coVerify { api.getCatalog() }
        coVerify { mapper.toDomain(testDto) }
    }

    @Test
    fun `getAllCardsApp should return empty list when api returns empty list`() = runTest {

        coEvery { api.getCatalog() } returns emptyList()

        val result = repository.getAllCardsApp()

        assertTrue(result.isEmpty())
        coVerify { api.getCatalog() }
    }

    @Test(expected = Exception::class)
    fun `getAllCardsApp should throw exception when api fails`() = runTest {

        coEvery { api.getCatalog() } throws RuntimeException("Network Error")

        repository.getAllCardsApp()
    }

    @Test
    fun `findById should return domain model when api returns dto`() = runTest {

        val id = "1"
        coEvery { api.getAppCard(id) } returns testDto
        coEvery { mapper.toDomain(testDto) } returns testDomain

        val result = repository.findById(id)

        assertEquals(testDomain, result)
        coVerify { api.getAppCard(id) }
        coVerify { mapper.toDomain(testDto) }
    }

    @Test(expected = Exception::class)
    fun `findById should throw exception when api fails`() = runTest {

        val id = "1"
        coEvery { api.getAppCard(id) } throws RuntimeException("Not Found")

        repository.findById(id)
    }
}