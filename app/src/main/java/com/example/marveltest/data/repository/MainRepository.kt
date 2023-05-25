package com.example.marveltest.data.repository

import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.remote.domain.models.Series
import com.example.marveltest.data.util.Status
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getSeries(): Flow<Status<List<Series>>>

    suspend fun refreshSeries()
}