package com.example.marveltest.ui.adapter

import com.example.marveltest.R
import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.remote.domain.models.Series
import com.example.marveltest.data.remote.domain.models.SeriesResultDto

class SeriesAdapter(listSeries: List<Series>, listener: SeriesListener) :
    BaseAdapter<Series>(listSeries, listener) {
    override val layoutId: Int
        get() = R.layout.series_item
}

interface SeriesListener : BaseAdapter.BaseInteractionListener {
    fun onClickSeries(id: Int)
}