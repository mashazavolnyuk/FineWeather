package com.mashazavolnyuk.fineweather

import com.mashazavolnyuk.fineweather.data.ResultWeather
import io.reactivex.Observable
import retrofit2.Retrofit

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IRequest {

    @GET("data/2.5/weather?")
    fun search(
        @Query("q") query: String,
        @Query("APPID") apiKey: String
    )
            : Observable<ResultWeather>

    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): IRequest {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.openweathermap.org/")
                .build()
            return retrofit.create(IRequest::class.java);
        }
    }

}