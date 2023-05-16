package com.example.composeweatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataObject(
    @field:Json(name = "time") val timeList: List<String>,
    @field:Json(name = "temperature_2m") val temperatureList: List<Double>,
    @field:Json(name = "weathercode") val weatherCodeList: List<Int>,
    @field:Json(name = "apparent_temperature") val apparentTemperatureList: List<Double>,
    @field:Json(name = "relativehumidity_2m") val relativeHumidityList: List<Double>,
    @field:Json(name = "windspeed_10m") val windSpeedList: List<Double>,
    @field:Json(name = "pressure_msl") val pressureList: List<Double>
)