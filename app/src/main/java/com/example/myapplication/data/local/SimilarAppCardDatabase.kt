package com.example.myapplication.data.local

import com.example.myapplication.data.dto.SimilarAppCardDto
import com.example.myapplication.data.dto.CategoryApp
import javax.inject.Inject

class SimilarAppCardDatabase @Inject constructor() : AppDetailsDao {

    private val similarAppCardDtoLists =listOf(
        SimilarAppCardDto(
            "1",
            "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
            "Герои меча и магии",
            "Стратегическая игра",
            CategoryApp.GAME
        ),
        SimilarAppCardDto(
            "2",
            "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
            "Тайны дикого леса",
            "1000 + 1 Головоломка",
            CategoryApp.GAME
        ),
        SimilarAppCardDto(
            "3",
            "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
            "Битва за трон",
            "А ты сможешь удержать трон?",
            CategoryApp.GAME
        ),
        SimilarAppCardDto(
            "4",
            "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
            "Иппадром",
            "Гонки на выживание",
            CategoryApp.GAME
        ),
        SimilarAppCardDto(
            "5",
            "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
            "Битва за трон",
            "А ты сможешь удержать трон?",
            CategoryApp.GAME
        ),
        SimilarAppCardDto(
            "6",
            "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
            "Герои меча и магии",
            "Стратегическая игра",
            CategoryApp.GAME
        ),
        SimilarAppCardDto(
            "7",
            "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
            "Тайны дикого леса",
            "1000 + 1 Головоломка",
            CategoryApp.GAME
        ),
        SimilarAppCardDto(
            "8",
            "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
            "Битва за трон",
            "А ты сможешь удержать трон?",
            CategoryApp.GAME
        ),
        SimilarAppCardDto(
            "9",
            "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
            "Иппадром",
            "Гонки на выживание",
            CategoryApp.GAME
        ),
    )

    override fun getAllCardsApp(): List<SimilarAppCardDto> {
        return similarAppCardDtoLists;
    }

    override fun findById(id: String): SimilarAppCardDto {
        return similarAppCardDtoLists.find { it.id == id }
            ?: throw NullPointerException("AppCard с id $id не найден")
    }
}