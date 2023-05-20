package com.example.marveltest.di

import com.example.marveltest.data.local.SeriesDao
import com.example.marveltest.data.remote.api.MarvelApiService
import com.example.marveltest.data.remote.domain.mapper.SeriesMapper
import com.example.marveltest.data.remote.domain.mapper.SeriesUIMapper
import com.example.marveltest.data.repository.MainRepository
import com.example.marveltest.data.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideRepository(
        seriesMapper: SeriesMapper,
        apiService: MarvelApiService,
        seriesDao: SeriesDao,
        seriesUIMapper: SeriesUIMapper
    ): MainRepository {
        return MainRepositoryImpl(apiService, seriesMapper, seriesUIMapper, seriesDao)
    }


    @Provides
    @Singleton
    fun provideSeriesMapper(): SeriesMapper {
        return SeriesMapper()
    }

    @Provides
    @Singleton
    fun provideSeriesUiMapper(): SeriesUIMapper {
        return SeriesUIMapper()
    }

}