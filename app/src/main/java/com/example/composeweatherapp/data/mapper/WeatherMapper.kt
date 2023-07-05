package com.example.composeweatherapp.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.composeweatherapp.data.remote.WeatherDTO
import com.example.composeweatherapp.data.remote.WeatherDataDTO
import com.example.composeweatherapp.domain.weather.WeatherDataClass
import com.example.composeweatherapp.domain.weather.WeatherInfo
import com.example.composeweatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherDataClass
)

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDTO.toWeatherDataMap():
        Map<Int, List<WeatherDataClass>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherDataClass(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}


//@RequiresApi(Build.VERSION_CODES.O)
//fun WeatherDataDto.toWeatherDataMap()
//        : Map<Int, List<WeatherDataClass>> {
//    return time.mapIndexed { index, time ->
//        val temperature = temperatures[index]
//        val weatherCode = weatherCodes[index]
//        val windSpeed = windSpeeds[index]
//        val pressure = pressures[index]
//        val humidity = humidities[index]
//        WeatherDataClass(
//            time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
//            temperatureCelsius = temperature,
//            pressure = pressure,
//            windSpeed = windSpeed,
//            humidity = humidity,
//            weatherType = WeatherType.fromWMO(weatherCode)
//        )
//    }.groupBy {
//        it.time.dayOfMonth
//    }
//}


@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDTO.toWeatherInfo():
        WeatherInfo{
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = when {
            now.minute < 30 -> now.hour
            now.hour == 23 -> 12.00
            else -> now.hour + 1
        }
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}























