package com.example.composeweatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    //    @GET("https://api.open-meteo.com/v1/gem?latitude=35.678&longitude=139.682&hourly=temperature_2m,weathercode,apparent_temperature,relativehumidity_2m,windspeed_10m,pressure_msl")

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getLocationData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): WeatherDTO

}