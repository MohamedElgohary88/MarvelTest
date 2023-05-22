package com.example.marveltest.ui.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.util.Status
import com.example.marveltest.data.remote.domain.SeriesResultDto
import com.example.marveltest.data.repository.MainRepository
import com.example.marveltest.data.repository.MainRepositoryImpl
import com.example.marveltest.ui.adapter.SeriesListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val repository: MainRepository) : ViewModel(), SeriesListener {

    val series = MutableLiveData<Status<List<SeriesEntity>>>()

    init {
        loadData()
    }

    fun loadData() {
        getSeries()
    }

    @SuppressLint("CheckResult")
    private fun getSeries() {

        repository.refreshSeries().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({}, {})

        repository.getSeries().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    it.toData()?.let {
                        series.postValue(Status.Success(it))
                        Log.i("mydata", it.toString())
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