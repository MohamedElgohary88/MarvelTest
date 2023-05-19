package com.example.marveltest.data.repository

import com.example.marveltest.data.util.Status
import com.example.marveltest.data.remote.api.Api
import com.example.marveltest.data.remote.domain.BaseResponse
import com.example.marveltest.data.remote.domain.SeriesResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MainRepositoryImpl : MainRepository {

    private val apiService by lazy { Api.apiService }

    override fun getSeries(): Single<Status<BaseResponse<SeriesResult>?>> {
        return wrapperToState(apiService.getSeries())
    }

    private fun <T> wrapperToState(response: Single<Response<BaseResponse<T>>>)
            : Single<Status<BaseResponse<T>?>> {
        return response.map {
            try {
                if (it.isSuccessful) {
                    Status.Success(it.body())
                } else {
                    Status.Failure(it.message())
                }
            } catch (e: Exception) {
                Status.Failure(e.message.toString())
            }
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

}