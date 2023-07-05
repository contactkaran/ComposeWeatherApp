package com.example.composeweatherapp.domain.repository

import com.example.composeweatherapp.domain.util.Resource
import com.example.composeweatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(
        latitude: Double,
    longitude: Double):
            Resource<WeatherInfo>
}