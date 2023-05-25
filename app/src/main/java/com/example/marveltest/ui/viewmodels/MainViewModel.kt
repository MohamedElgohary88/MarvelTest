package com.example.marveltest.ui.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.remote.domain.models.Series
import com.example.marveltest.data.util.Status
import com.example.marveltest.data.repository.MainRepository
import com.example.marveltest.ui.adapter.SeriesListener
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(),
    SeriesListener {

    val series: LiveData<Status<List<Series>>> = repository.getSeries().asLiveData()

    //MutableStateFlow(repository.getSeries()).asLiveData()

    init {
        loadData()
    }
    fun loadData() {}

    override fun onClickSeries(id: Int) {
        Log.d("mimo", id.toString())
    }
}