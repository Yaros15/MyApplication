package com.example.myapplication.data.mapper

import com.example.myapplication.data.dto.AppCardDto
import com.example.myapplication.domain.domainModel.AppCard
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppCardMapperTest {

    private lateinit var mapper: AppCardMapper

    @Before
    fun setUp() {
        mapper = AppCardMapper()
    }

    @Test
    fun `toDomain should correctly map all fields`() {

        val dto = AppCardDto(
            id = "123",
            iconUrl = "https://icon.png",
            name = "Test App",
            description = "Description",
            categoryApp = "Game"
        )


        val domain = mapper.toDomain(dto)

        assertEquals(dto.id, domain.id)
        assertEquals(dto.iconUrl, domain.iconUrl)
        assertEquals(dto.name, domain.name)
        assertEquals(dto.description, domain.description)
        assertEquals(dto.categoryApp, domain.categoryApp)
    }

    @Test
    fun `toDomain should handle empty strings`() {

        val dto = AppCardDto("", "", "", "", "")
        val domain = mapper.toDomain(dto)

        assertEquals("", domain.id)
        assertEquals("", domain.name)
    }

    @Test
    fun `toDTO should correctly map all fields`() {

        val domain = AppCard(
            id = "456",
            iconUrl = "https://icon2.png",
            name = "Domain App",
            description = "Domain Desc",
            categoryApp = "Utility"
        )

        val dto = mapper.toDTO(domain)

        assertEquals(domain.id, dto.id)
        assertEquals(domain.iconUrl, dto.iconUrl)
        assertEquals(domain.name, dto.name)
        assertEquals(domain.description, dto.description)
        assertEquals(domain.categoryApp, dto.categoryApp)
    }

    @Test
    fun `toDTO should handle empty strings`() {
        val domain = AppCard("", "", "", "", "")
        val dto = mapper.toDTO(domain)

        assertEquals("", dto.id)
        assertEquals("", dto.name)
    }

    @Test
    fun `mapping toDomain and back toDTO should return same object`() {
        val originalDto = AppCardDto("1", "url", "name", "desc", "cat")
        val domain = mapper.toDomain(originalDto)
        val resultDto = mapper.toDTO(domain)

        assertEquals(originalDto, resultDto)
    }
}