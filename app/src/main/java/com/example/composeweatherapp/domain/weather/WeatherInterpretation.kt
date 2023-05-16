package com.example.composeweatherapp.domain.weather

import androidx.annotation.DrawableRes
import com.example.composeweatherapp.R

//TODO - Material design icons from https://pictogrammers.com/library/mdi/

//Trying to parse type of weather data once and map it to DTO objects

sealed class WeatherInterpretation (val WeatherDescription: String, @DrawableRes val iconRes: Int){

    object ClearSky: WeatherInterpretation("Clear Sky", R.drawable.ic_clear_sky)

    object MainlyClear: WeatherInterpretation("Mainly Clear", R.drawable.ic_partly_cloudy)
    object PartlyCloudy: WeatherInterpretation("Partly Cloudy", R.drawable.ic_partly_cloudy)
    object Overcast: WeatherInterpretation("Overcast", R.drawable.ic_partly_cloudy)

    object Fog: WeatherInterpretation("Fog", R.drawable.ic_fog)
    object DepositingRimeFog: WeatherInterpretation("Despositing Rime Fog", R.drawable.ic_fog)

    object DrizzleLight: WeatherInterpretation("Light Drizzle", R.drawable.ic_drizzle)
    object DrizzleModerate: WeatherInterpretation("Moderate Drizzle", R.drawable.ic_drizzle)
    object DrizzleDenseIntensity: WeatherInterpretation("Dense Intensity Drizzle", R.drawable.ic_drizzle)

    object FreezingDrizzleLight: WeatherInterpretation("Light Freezing Drizzle", R.drawable.ic_freezing_drizzle)
    object FreezingDrizzleDense: WeatherInterpretation("Dense Freezing Drizzle", R.drawable.ic_freezing_drizzle)

    object RainSlight: WeatherInterpretation("Slight Rain", R.drawable.ic_rain)
    object RainModerate: WeatherInterpretation("Slight Rain", R.drawable.ic_rain)
    object RainHeavy: WeatherInterpretation("Slight Rain", R.drawable.ic_rain)

    object FreezingRainLight: WeatherInterpretation("Light Freezing Rain", R.drawable.ic_freezing_rain)
    object FreezingRainHeavy: WeatherInterpretation("Heavy Freezing Rain", R.drawable.ic_freezing_rain)

    object SnowFallSlight: WeatherInterpretation("Slight Snow Fall", R.drawable.ic_snow)
    object SnowFallModerate: WeatherInterpretation("Moderate Snow Fall", R.drawable.ic_snow)
    object SnowFallHeavy: WeatherInterpretation("Heavy Snow Fall", R.drawable.ic_snow)

    object SnowGrains: WeatherInterpretation("Snow Grains", R.drawable.ic_snow_grains)

    object RainShowersSlight: WeatherInterpretation("Light Rain Showers", R.drawable.ic_rain_showers)
    object RainShowersModerate: WeatherInterpretation("Moderate Rain Showers", R.drawable.ic_rain_showers)
    object RainShowersViolent: WeatherInterpretation("Violent Rain Showers", R.drawable.ic_rain_showers)

    object SnowShowersSlight: WeatherInterpretation("Slight Snow Showers", R.drawable.ic_snow_showers)
    object SnowShowersHeavy: WeatherInterpretation("Heavy Snow Showers", R.drawable.ic_snow_showers)

    object ThunderstormSlight: WeatherInterpretation("Slight Thunderstorm", R.drawable.ic_thunderstorm)
    object ThunderstormHeavy: WeatherInterpretation("Heavy Thunderstorm", R.drawable.ic_thunderstorm)

    object ThunderstormHailSlight: WeatherInterpretation("Thunderstorm with Slight Hail", R.drawable.ic_thunderstorm_hail)
    object ThunderstormHailHeavy: WeatherInterpretation("Thunderstorm with Heavy Hail", R.drawable.ic_thunderstorm_hail)

    object WeatherFetchError: WeatherInterpretation("Weather Fetch Error - check connection", R.drawable.ic_error)

/*
0	Clear sky
1, 2, 3	Mainly clear, partly cloudy, and overcast
45, 48	Fog and depositing rime fog
51, 53, 55	Drizzle: Light, moderate, and dense intensity
56, 57	Freezing Drizzle: Light and dense intensity
61, 63, 65	Rain: Slight, moderate and heavy intensity
66, 67	Freezing Rain: Light and heavy intensity
71, 73, 75	Snow fall: Slight, moderate, and heavy intensity
77	Snow grains
80, 81, 82	Rain showers: Slight, moderate, and violent
85, 86	Snow showers slight and heavy
95 *	Thunderstorm: Slight or moderate
96, 99 *	Thunderstorm with slight and heavy hail
*/


    companion object{
        fun weatherVariable(weatherCode: Int): WeatherInterpretation {
            return when(weatherCode){
                0 -> ClearSky
                1 -> MainlyClear
                2-> PartlyCloudy
                3 -> Overcast
                45 -> Fog
                48 -> DepositingRimeFog
                51 -> DrizzleLight
                53 -> DrizzleModerate
                55 -> DrizzleDenseIntensity
                56 -> FreezingDrizzleLight
                57 -> FreezingDrizzleDense
                61 -> RainSlight
                63 -> RainModerate
                65 -> RainHeavy
                66 -> FreezingRainLight
                67 -> FreezingRainHeavy
                71 -> SnowFallSlight
                73 -> SnowFallModerate
                75 -> SnowFallHeavy
                77 -> SnowGrains
                80 -> RainShowersSlight
                81 -> RainShowersModerate
                82 -> RainShowersViolent
                85 -> SnowShowersSlight
                86 -> SnowShowersHeavy
                95 -> ThunderstormSlight
                96 -> ThunderstormHailSlight
                99 -> ThunderstormHailHeavy
                else -> WeatherFetchError
            }
        }
    }
}