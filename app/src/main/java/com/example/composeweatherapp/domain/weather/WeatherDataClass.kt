package com.example.composeweatherapp.domain.weather

import java.time.LocalDateTime

//data can be parsed once from API and stored for display

data class WeatherDataClass(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val apparentTemperature: Double,
    val relativeHumidity: Double,
    val windSpeed: Double,
    val pressure: Double,
    val weatherType: WeatherType
)