package com.plcoding.stockmarketapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.stockmarketapp.data.local.StockDatabase
import com.plcoding.stockmarketapp.data.remote.StocksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStockApi(): StocksAPI {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY;

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build();

        val retrofit = Retrofit.Builder()
            .baseUrl(StocksAPI.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideStockDB(app : Application): StockDatabase {
        return Room.databaseBuilder(
            app,
            StockDatabase::class.java,
            "stockdb.db"
        ).build()
    }
}