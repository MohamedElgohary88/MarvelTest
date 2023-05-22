package com.example.marveltest

import android.content.Context
import com.example.marveltest.data.local.SeriesDatabase
import com.example.marveltest.data.mapper.SeriesMapper
import com.example.marveltest.data.remote.api.Api
import com.example.marveltest.data.remote.api.MarvelApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DepndancyContainer(context: Context) {

    val seriesDao = SeriesDatabase.getInstance(context).seriesDao()

    val seriesMapper = SeriesMapper()

    private val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(Api.BASE_URl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val apiService = retrofit.create(MarvelApiService::class.java)

}