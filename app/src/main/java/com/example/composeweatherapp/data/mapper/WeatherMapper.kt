package com.example.composeweatherapp.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.composeweatherapp.data.remote.WeatherDataObject
import com.example.composeweatherapp.data.remote.WeatherDataTransferObject
import com.example.composeweatherapp.domain.weather.WeatherData
import com.example.composeweatherapp.domain.weather.WeatherDetails
import com.example.composeweatherapp.domain.weather.WeatherInterpretation
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//now we map the obtained data to local variables
//all lists have same length
//API returns hourly temp, hence we need a map with 24 x 7 entries


data class WeatherDataIndexed(val index: Int, val data: WeatherData)

//extension functions to map one API object to local object
@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataObject.toWeatherDetailsMap(): Map<Int, List<WeatherData>> {
    //refers to the map here WeatherDetails.kt map the Date to the corresponding weatherData
    //if date is 0 i.e. today, the list will have data for each of the 24 hours
    return timeList.mapIndexed { index, time ->
        //list of time string (hours) being mapped to related data for that particular hour
        //mapIndexed runs a loop
        //mapping time values to data sets
        // the value for index variable will be large as it provides 24 hours x 7 days
        val temperature = temperatureList[index]
        val weatherCode = weatherCodeList[index]
        val apparentTemperature = apparentTemperatureList[index]
        val relativeHumidity = relativeHumidityList[index]
        val windSpeed = windSpeedList[index]
        val pressure = pressureList[index]
        WeatherDataIndexed(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                apparentTemperature = apparentTemperature,
                relativeHumidity = relativeHumidity,
                windSpeed = windSpeed,
                pressure = pressure,
                weatherInterpretation = WeatherInterpretation.weatherVariable(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24   //where 24/24 will become index 1 i.e. next day
    }.mapValues {
        it.value.map { it.data }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataTransferObject.toWeatherDetails(): WeatherDetails {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentTimeWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherDetails(
        TodaysWeatherData = weatherDataMap, currentTimeWeatherData = currentTimeWeatherData
    )
}