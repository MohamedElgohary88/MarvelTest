package com.example.marveltest.ui.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.remote.domain.models.Series
import com.example.marveltest.data.util.Status
import com.example.marveltest.data.repository.MainRepository
import com.example.marveltest.ui.adapter.SeriesListener
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel(), SeriesListener {

    val series = MutableLiveData<Status<List<Series>>>()

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
                    ::onSeriesSuccess
                    Log.i("what", it.toString())
                },
                {
                    Log.i("whatt", it.toString())
                }
            )
    }

    private fun onSeriesSuccess(status: List<Series>) {
        status.let { result ->
            series.postValue(Status.Success(result))
            Log.i("post", result.toString())
        }
    }

    override fun onClickSeries(id: Int) {
        Log.d("mimo", id.toString())
    }
}