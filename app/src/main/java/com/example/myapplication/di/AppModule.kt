package com.example.myapplication.di

import com.example.myapplication.data.local.AppCardApi
import com.example.myapplication.data.repositoriImpl.AppCardRepoImpl
import com.example.myapplication.domain.repository.AppCardRepo
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://185.103.109.134")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideAppCardApi(retrofit: Retrofit): AppCardApi {
        return retrofit.create(AppCardApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppCardRepo(appCardRepoImpl: AppCardRepoImpl): AppCardRepo{
        return appCardRepoImpl
    }

}