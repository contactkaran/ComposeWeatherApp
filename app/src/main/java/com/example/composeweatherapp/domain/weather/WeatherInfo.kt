package com.example.composeweatherapp.domain.weather

//mapping data of current date with corresponding weather data

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherDataClass>>,
    val currentWeatherData: WeatherDataClass?
)