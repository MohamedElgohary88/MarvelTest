package com.example.marveltest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SeriesEntity::class], version = 1, exportSchema = false)
abstract class SeriesDatabase : RoomDatabase() {

    abstract val seriesDao: SeriesDao

}