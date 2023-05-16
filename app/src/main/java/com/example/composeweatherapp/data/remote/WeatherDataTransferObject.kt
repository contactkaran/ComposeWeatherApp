package com.example.composeweatherapp.data.remote

import com.squareup.moshi.Json

//Data representation of JSON response from Retrofit API
//ideally the variable name should be same as JSON file i.e. "hourly" but since we are changing it a desired name, we annotate

data class WeatherDataTransferObject (
    @field:Json(name = "hourly")
    val weatherData: WeatherDataTransferObject
)

