package com.example.marveltest.data.remote.domain.mapper

import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.remote.domain.models.Series
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SeriesUIMapper @Inject constructor() : Mapper<SeriesEntity, Series> {
    override fun map(input: SeriesEntity): Series {
        return Series(
            id = input.id,
            imageURL = input.imageURL,
            title = input.title
        )
    }
}