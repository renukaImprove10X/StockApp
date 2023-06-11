package com.plcoding.stockmarketapp.data.remote

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StocksAPI {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey:String = API_KEY
    ) : ResponseBody

    companion object{
        const val API_KEY = "RL7JTM607IRNO1HC"
        const val BASE_URL = "https://alphavantage.co"
    }
}