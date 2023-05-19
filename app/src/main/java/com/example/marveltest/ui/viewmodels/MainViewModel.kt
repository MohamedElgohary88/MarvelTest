package com.example.marveltest.ui.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marveltest.data.util.Status
import com.example.marveltest.data.remote.domain.SeriesResult
import com.example.marveltest.data.repository.MainRepository
import com.example.marveltest.data.repository.MainRepositoryImpl
import com.example.marveltest.ui.adapter.SeriesListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel(), SeriesListener {
    val series = MutableLiveData<Status<List<SeriesResult>>>()
    private val repository: MainRepository by lazy { MainRepositoryImpl() }

    init {
        loadData()
    }

    fun loadData() {
        getSeries()
    }

    @SuppressLint("CheckResult")
    private fun getSeries() {
        repository.getSeries().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    it.toData()?.data?.seriesResults?.let { result ->
                        series.postValue(Status.Success(result))
                    }
                },
                {
                    Log.i("Mimo", it.toString())
                }
            )
    }

    override fun onClickSeries(id: Int) {
        Log.d("mimo", id.toString())
    }
}