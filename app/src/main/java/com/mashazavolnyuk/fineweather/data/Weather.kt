package com.mashazavolnyuk.fineweather.data

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)