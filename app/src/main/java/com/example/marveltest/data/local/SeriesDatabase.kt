package com.example.marveltest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [SeriesEntity::class], version = 1)
abstract class SeriesDatabase : RoomDatabase() {

    abstract fun seriesDao(): SeriesDao

    companion object {
        private const val DATABASE_NAME = "MyNoteDatabase"

        @Volatile
        private var instance: SeriesDatabase? = null

        fun getInstance(context: Context): SeriesDatabase {
            return instance ?: synchronized(this) { buildDatabase(context) }.also { instance = it }
        }

        private fun buildDatabase(context: Context): SeriesDatabase {
            return Room.databaseBuilder(context, SeriesDatabase::class.java, DATABASE_NAME).build()
        }

        fun getInstanceWithoutContext(): SeriesDatabase {
            return instance!!
        }
    }
}