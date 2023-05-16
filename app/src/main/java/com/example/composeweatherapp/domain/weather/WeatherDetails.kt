package com.example.composeweatherapp.domain.weather

//mapping data of current date with corresponding weather data

data class WeatherDetails(
    val TodaysWeatherData: Map<Int, List<WeatherData>>,
    val currentTimeWeatherData: WeatherData?
)