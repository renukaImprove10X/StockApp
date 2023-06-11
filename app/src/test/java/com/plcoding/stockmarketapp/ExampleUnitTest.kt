package com.plcoding.stockmarketapp

import com.plcoding.stockmarketapp.di.AppModule
import com.plcoding.stockmarketapp.data.remote.StocksAPI
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun apiCall(){
        val retrofit = Retrofit.Builder()
            .baseUrl(StocksAPI.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val stocks : StocksAPI = retrofit.create()
//        println(stocks.getListings())
    }
}