package com.example.marveltest.di

import android.content.Context
import androidx.room.Room
import com.example.marveltest.data.local.SeriesDao
import com.example.marveltest.data.local.SeriesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideMarvelDataBase(
        @ApplicationContext appContext: Context,
    ): SeriesDatabase {
        return Room.databaseBuilder(
            appContext, SeriesDatabase::class.java,
            "MarvelDataBase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMarvelDao(
        seriesDatabase: SeriesDatabase
    ): SeriesDao {
        return seriesDatabase.seriesDao
    }
}