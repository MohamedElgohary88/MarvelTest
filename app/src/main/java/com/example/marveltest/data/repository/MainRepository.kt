package com.example.marveltest.data.repository

import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.remote.domain.models.Series
import com.example.marveltest.data.util.Status
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface MainRepository {

    fun getSeries(): Observable<Status<List<Series>>>

    fun refreshSeries(): Completable
}