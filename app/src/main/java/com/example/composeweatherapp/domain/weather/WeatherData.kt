package com.example.composeweatherapp.domain.weather

import com.squareup.moshi.Json
import java.time.LocalDateTime

//data can be parsed once from API and stored for display

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val apparentTemperature: Double,
    val relativeHumidity: Double,
    val windSpeed: Double,
    val pressure: Double,
    val weatherInterpretation: WeatherInterpretation
)