package com.example.marveltest.data.remote.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O

}