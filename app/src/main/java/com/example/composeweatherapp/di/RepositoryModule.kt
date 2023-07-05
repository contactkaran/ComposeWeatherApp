package com.example.composeweatherapp.di

import com.example.composeweatherapp.data.location.DefaultLocationTracker
import com.example.composeweatherapp.data.repository.WeatherRepositoryImpl
import com.example.composeweatherapp.domain.location.LocationTracker
import com.example.composeweatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}