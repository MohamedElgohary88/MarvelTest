package com.example.marveltest.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.example.marveltest.data.local.SeriesDao
import com.example.marveltest.data.remote.api.MarvelApiService
import com.example.marveltest.data.remote.domain.mapper.SeriesMapper
import com.example.marveltest.data.remote.domain.mapper.SeriesUIMapper
import com.example.marveltest.data.remote.domain.models.Series
import com.example.marveltest.data.util.Status
import io.reactivex.rxjava3.core.Completable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: MarvelApiService,
    private val seriesMapper: SeriesMapper,
    private val seriesUIMapper: SeriesUIMapper,
    private val seriesDao: SeriesDao

) : MainRepository {

    override fun getSeries(): Flow<Status<List<Series>>> {
        return seriesDao.getAllSeries().map {
            Status.Success(it.map { item -> seriesUIMapper.map(item) })
        }
    }

    @SuppressLint("CheckResult")
    override fun refreshSeries() {
        val response = apiService.getSeries()
        Log.d("Mimo", response.toString())
        return response { baseResponse ->
            val items = baseResponse.body()?.data?.seriesResultDtos?.map {
                seriesMapper.map(it)
            }
            items?.let { seriesDao.insertSeries(it).subscribe() }
            Completable.complete()
        }
    }
}