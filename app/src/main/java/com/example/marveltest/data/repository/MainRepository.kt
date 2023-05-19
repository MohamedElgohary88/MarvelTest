package com.example.marveltest.data.repository

import com.example.marveltest.data.remote.domain.SeriesResult
import com.example.marveltest.data.util.Status
import com.example.marveltest.data.remote.domain.BaseResponse
import io.reactivex.rxjava3.core.Single

interface MainRepository {

    fun getSeries(): Single<Status<BaseResponse<SeriesResult>?>>
}