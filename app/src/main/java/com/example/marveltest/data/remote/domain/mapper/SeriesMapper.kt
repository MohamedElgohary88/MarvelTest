package com.example.marveltest.data.remote.domain.mapper

import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.remote.domain.models.SeriesResultDto

class SeriesMapper : Mapper<SeriesResultDto, SeriesEntity> {
    override fun map(input: SeriesResultDto): SeriesEntity {
        return SeriesEntity(
            id = input.id ?: 0,
            description = input.description ?: "",
            imageURL = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            title = input.title ?: ""
        )
    }
}