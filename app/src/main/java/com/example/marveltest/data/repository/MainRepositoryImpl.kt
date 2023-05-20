package com.example.marveltest.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.example.marveltest.data.local.SeriesDao
import com.example.marveltest.data.local.SeriesDatabase
import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.util.Status
import com.example.marveltest.data.remote.api.Api
import com.example.marveltest.data.remote.api.MarvelApiService
import com.example.marveltest.data.remote.domain.mapper.SeriesMapper
import com.example.marveltest.data.remote.domain.mapper.SeriesUIMapper
import com.example.marveltest.data.remote.domain.models.BaseResponse
import com.example.marveltest.data.remote.domain.models.Series
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiService,
    private val seriesMapper: SeriesMapper,
    private val seriesUIMapper: SeriesUIMapper,
    private val seriesDao: SeriesDao

) : MainRepository {

    override fun getSeries(): Observable<Status<List<Series>>> {
        return seriesDao.getAllSeries().map {
            Status.Success(it.map { item -> seriesUIMapper.map(item) })
        }
    }

    @SuppressLint("CheckResult")
    override fun refreshSeries(): Completable {
        val response = apiService.getSeries()
        Log.d("Mimo", response.toString())
        return response.flatMapCompletable { baseResponse ->
            val items = baseResponse.body()?.data?.seriesResultDtos?.map {
                seriesMapper.map(it)
            }
            items?.let { seriesDao.insertSeries(it).subscribe() }
            Completable.complete()
        }
    }
}