package com.example.composeweatherapp.domain.weather

import java.time.LocalDateTime

//data can be parsed once from API and stored for display

data class WeatherDataClass(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)