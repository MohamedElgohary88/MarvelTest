package com.example.marveltest.di

import com.example.marveltest.data.remote.api.Api
import com.example.marveltest.data.remote.api.MarvelApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(
        gsonConverterFactory: GsonConverterFactory,
        client: OkHttpClient,
        rxJava3CallAdapterFactory: RxJava3CallAdapterFactory
    ): MarvelApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URl)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .addCallAdapterFactory(rxJava3CallAdapterFactory)
            .build()
        return retrofit.create(MarvelApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }


    @Provides
    @Singleton
    fun provideRxJava3CallAdapterFactory(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()
    }

}