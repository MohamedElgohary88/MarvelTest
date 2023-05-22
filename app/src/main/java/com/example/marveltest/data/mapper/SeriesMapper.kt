package com.example.marveltest.data.mapper

import com.example.marveltest.data.local.SeriesEntity
import com.example.marveltest.data.remote.domain.SeriesResultDto

class SeriesMapper : Mapper<SeriesResultDto, SeriesEntity> {
    override fun map(input: SeriesResultDto): SeriesEntity {
        return SeriesEntity(
            id = input.id ?: 0,
            title = input.title ?: "",
            description = input.description ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}