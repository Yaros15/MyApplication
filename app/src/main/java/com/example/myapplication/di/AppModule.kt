package com.example.myapplication.di

import com.example.myapplication.data.local.AppCardDatabase
import com.example.myapplication.data.local.AppDetailsDao
import com.example.myapplication.data.repositoriImpl.AppCardRepoImpl
import com.example.myapplication.domain.repository.AppCardRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindAppCardRepo(appCardRepoImpl: AppCardRepoImpl): AppCardRepo

    @Binds
    @Singleton
    abstract fun bindAppDetailsDao(appCardDatabase: AppCardDatabase): AppDetailsDao

}