package com.example.marveltest.data.repository

import android.util.Log
import com.example.marveltest.data.local.SeriesDao
import com.example.marveltest.data.local.SeriesDatabase
import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.mapper.SeriesMapper
import com.example.marveltest.data.remote.api.Api
import com.example.marveltest.data.remote.api.MarvelApiService
import com.example.marveltest.data.util.Status
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class MainRepositoryImpl(
    private val apiService: MarvelApiService,
    private val seriesMapper: SeriesMapper,
    private val seriesdao: SeriesDao
) : MainRepository {

    override fun refreshSeries(): Completable {
        val response = apiService.getSeries()
        return response.concatMapCompletable { baseResponse ->
            val items = baseResponse.body()?.data?.seriesResultDtos?.map {
                seriesMapper.map(it)
            }
            items?.let { seriesdao.insertSeries(items).subscribe() }
            Log.i("items", items.toString())
            Completable.complete()
        }
    }

    override fun getSeries(): Observable<Status<List<SeriesEntity>?>> {
        return seriesdao.getAllSeries().map { Status.Success(it) }
    }
}