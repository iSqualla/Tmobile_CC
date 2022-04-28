package com.example.tmobile.di

import com.example.tmobile.network.RetroAPIService
import com.example.tmobile.ui.controller.MainRepository
import com.example.tmobile.ui.controller.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@InstallIn(ActivityComponent::class)
@Module
object RepoModule{

    @Singleton
    @Provides
    fun providesMainRepository(retroAPI: RetroAPIService): MainRepository{
        return MainRepositoryImpl(retroAPI)
    }
}