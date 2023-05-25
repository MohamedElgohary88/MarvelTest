package com.example.marveltest.data.remote.api

import com.example.marveltest.data.remote.domain.models.BaseResponse
import com.example.marveltest.data.remote.domain.models.SeriesResultDto
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val Api_Key = "ff5123154d30d947ea895d048a5cc47c&hash=82b68ee18585f04cb64af92941699f9c"


interface MarvelApiService {
    @GET("v1/public/series?ts=1&apikey=$Api_Key")
    suspend fun getSeries(): Response<BaseResponse<SeriesResultDto>>
}

object Api {
    const val BASE_URl = "https://gateway.marvel.com/"
}