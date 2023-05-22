package com.example.marveltest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface SeriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeries(seriesList: List<SeriesEntity>): Completable

    @Query("SELECT * FROM SERIES_TABLE")
    fun getAllSeries(): Observable<List<SeriesEntity>>

}