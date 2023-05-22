package com.example.marveltest.ui.adapter

import com.example.marveltest.R
import com.example.marveltest.data.remote.domain.SeriesResultDto

class SeriesAdapter(var listSeries: List<SeriesResultDto>, listener: SeriesListener) :
    BaseAdapter<SeriesResultDto>(listSeries, listener) {
    override val layoutId: Int
        get() = R.layout.series_item
}

interface SeriesListener : BaseAdapter.BaseInteractionListener {
    fun onClickSeries(id: Int)
}