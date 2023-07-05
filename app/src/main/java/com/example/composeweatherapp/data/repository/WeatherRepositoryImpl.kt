package com.example.composeweatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.composeweatherapp.data.mapper.toWeatherInfo
import com.example.composeweatherapp.data.remote.WeatherApi
import com.example.composeweatherapp.domain.repository.WeatherRepository
import com.example.composeweatherapp.domain.util.Resource
import com.example.composeweatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Resource<WeatherInfo> {

        return try {
            Resource.Success(
                data = api.getLocationData(
                    latitude = latitude,
                    longitude = longitude
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Error occurred.")
        }
    }

}